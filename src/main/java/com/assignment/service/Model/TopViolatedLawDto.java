package com.assignment.service.Model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class TopViolatedLawDto {
    private String lawId;
    private int count;
}
