package com.example.msa_03_application.controller;

import com.example.msa_03_application.dto.CreditApplicationRequest;
import com.example.msa_03_application.dto.CreditApplicationResponse;
import com.example.msa_03_application.model.CreditApplication;
import com.example.msa_03_application.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-applications")
@RequiredArgsConstructor
public class CreditApplicationController {
    private final CreditApplicationService service;

    @PostMapping
    public CreditApplicationResponse createApplication(@RequestBody CreditApplicationRequest request) {
        System.out.println("IN CONTROLLER " + request);
        int id = service.createApplication(request);
        System.out.println("IN CONTROLLER " + id);
        return new CreditApplicationResponse(id);
    }
    @GetMapping("/{id}/status")
    public boolean getApplicationStatus(@PathVariable Integer id){
        return service.getApplicationStatus(id);
    }

    @GetMapping
    public List<CreditApplication> getAllApplications(){
        return service.getAllApplications();
    }
}
