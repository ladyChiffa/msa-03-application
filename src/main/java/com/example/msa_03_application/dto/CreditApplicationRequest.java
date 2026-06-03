package com.example.msa_03_application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationRequest {
    private Integer id;
    private Integer amount;
    private String term;
    private Integer income;
    private Integer currentCreditLoad;
    private Integer creditRating;
}
