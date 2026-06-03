package com.example.msa_03_application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationEvent {
    private Integer id;
    private Integer amount;
    private String term;
    private Integer income;
    private Integer currentCreditLoad;
    private Integer creditRating;
}
