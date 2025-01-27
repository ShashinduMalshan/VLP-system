package com.assignment.service.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PoliceOfficer implements Serializable {

        String OfficerId;
        String name;
        String location;
}
