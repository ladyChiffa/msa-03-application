package com.example.msa_03_application.repository;

import com.example.msa_03_application.model.CreditApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CreditApplicationRepository {
    private final List<CreditApplication> repo = new ArrayList<>();

    public CreditApplication save(CreditApplication app) {
        Optional<CreditApplication> repoApp = findById(app.getId());
        if (repoApp.isEmpty()) {
            repo.add(app);
        }
        return app;
    }

    public List<CreditApplication> getAll() {
        return repo;
    }

    public Optional<CreditApplication> findById(Long id) {
        for (CreditApplication app : repo) {
            if(app.getId() == id) {
                return Optional.of(app);
            }
        }
        return Optional.empty();
    }
}
