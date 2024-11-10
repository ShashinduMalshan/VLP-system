package com.assignment.service.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TrafficViolationLawTM {
    private String lawId;
    private String description;
    private int lawPoints;
}
