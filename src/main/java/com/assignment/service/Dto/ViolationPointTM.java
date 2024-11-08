package com.assignment.service.Dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViolationPointTM {

    private String point_id;
    private String description;
    private String location;
    private String violationTime;
    private String violationDate;
    private String officerId;
    private String driverLicenseNumber;
    private String revenueLicenseNumber;
    private String lawId;

}
