package com.example.msa_03_application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDecisionEvent {
    private Long id;
    boolean approved;
}
