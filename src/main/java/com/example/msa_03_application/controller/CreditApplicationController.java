package com.example.msa_03_application.controller;

import com.example.msa_03_application.dto.CreditApplicationRequest;
import com.example.msa_03_application.dto.CreditApplicationResponse;
import com.example.msa_03_application.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-applications")
@RequiredArgsConstructor
public class CreditApplicationController {
    private final CreditApplicationService service;

    @PostMapping
    public CreditApplicationResponse createApplication(@RequestBody CreditApplicationRequest request) {
        System.out.println("IN CONTROLLER " + request);
        long id = service.createApplication(request);
        System.out.println("IN CONTROLLER " + id);
        return new CreditApplicationResponse(id);
    }
/*
    @GetMapping("/{id}/status")
    public ApplicationStatus getApplicationStatus(@PathVariable Long id){
        return service.getApplicationStatus(id);
    }

    @GetMapping
    public List<CreditApplicationListResponse> getAllApplications(){
        return service.getAllApplications();
    }
*/
/*
    @GetMapping("/new")
    public String createApplication() {
        service.createApplication();
        return "ok";
    }
*/
}
