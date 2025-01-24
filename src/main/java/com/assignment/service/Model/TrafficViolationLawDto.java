package com.assignment.service.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TrafficViolationLawDto {
    private String lawId;
    private String description;
    private int lawPoints;


}
