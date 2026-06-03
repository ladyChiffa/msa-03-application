package com.example.msa_03_application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplication {
    private Integer id;
    private Integer amount;
    private String term;
    private Integer income;
    private Integer currentCreditLoad;
    private Integer creditRating;
    private Boolean status;
}
