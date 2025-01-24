package com.assignment.service.Model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SuspendDriversDetailsDto {

    String name;
    String timeDuration;
    int  totalPoint;
    String drivingLicNum;


}
