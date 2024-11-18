package com.assignment.service.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class TrainingTM {
    private String courseId;
    private String name;
    private String duration;
    private int  totalPoint;
    private String driverId;
}
