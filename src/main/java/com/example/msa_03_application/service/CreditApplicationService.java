package com.example.msa_03_application.service;

import com.example.msa_03_application.dto.CreditApplicationRequest;
import com.example.msa_03_application.dto.CreditApplicationResponse;
import com.example.msa_03_application.event.CreditApplicationEvent;
import com.example.msa_03_application.event.CreditDecisionEvent;
import com.example.msa_03_application.model.CreditApplication;
import com.example.msa_03_application.repository.CreditApplicationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditApplicationService {
    private final CreditApplicationRepository repository;
    private final KafkaTemplate<String, CreditApplicationEvent> kafkaTemplate;

    public Long createApplication(CreditApplicationRequest request) {
        CreditApplication application = new CreditApplication();
        application.setId(102L);
        BeanUtils.copyProperties(request, application);
        application = repository.save(application);

        CreditApplicationEvent event = new CreditApplicationEvent(
                application.getId(), // 102
                application.getAmount(), //1_000_000
                application.getTerm(),
                application.getIncome(),
                application.getCurrentCreditLoad(),
                application.getCreditRating()
        );

        System.out.println("IN SERVICE sending event");
        kafkaTemplate.send("credit-applications", event);
        return application.getId();
    }

    public boolean getApplicationStatus(Long id) {
        return repository.findById(id)
                .map(CreditApplication::getStatus)
                .orElseThrow(() -> new RuntimeException("Not found id=" + id ));
    }

    public List<CreditApplication> getAllApplications() {
        return repository.getAll();
    }

    @RabbitListener(queues =  "credit-decisions")
    public void handleCreditDecision(CreditDecisionEvent event) {
        System.out.println("IN LISTENER " + event);
        Optional<CreditApplication> app = repository.findById(event.getId());
        if (app.isEmpty()) {
            CreditApplication fakeApplication = new CreditApplication();
            fakeApplication.setId(event.getId());
            fakeApplication.setStatus(event.isApproved());
            repository.save(fakeApplication);
        }
        else {
            app.get().setStatus(event.isApproved());
            repository.save(app.get());
        }
    }

}
