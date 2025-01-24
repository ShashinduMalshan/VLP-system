package com.assignment.service.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TopViolatedPointDto {
    private String lawId;
    private int point;
}
