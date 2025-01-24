package com.assignment.service.Model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuspendLicTM {

    private String suspendId;
    private String driverName;
    private String timeDuration;
    private int   points;
    private String   driverId;
}
