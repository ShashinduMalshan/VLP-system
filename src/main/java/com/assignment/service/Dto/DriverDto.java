package com.assignment.service.Dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DriverDto {
   String drivingLicNum;
   String name;
   String email;
   int  totalPoint;

}
