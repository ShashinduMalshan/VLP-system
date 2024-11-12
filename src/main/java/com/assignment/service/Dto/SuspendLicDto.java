package com.assignment.service.Dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SuspendLicDto {
    private String suspendId;
    private String driverName;
    private String timeDuration;
    private int   points;
    private String   driverId;

}
