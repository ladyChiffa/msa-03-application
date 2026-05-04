package com.example.msa_03_application.repository;

import com.example.msa_03_application.model.CreditApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreditApplicationRepository {
    private final List<CreditApplication> repo = new ArrayList<>();

    public CreditApplication save(CreditApplication app) {
        repo.add(app);
        return app;
    }
}
