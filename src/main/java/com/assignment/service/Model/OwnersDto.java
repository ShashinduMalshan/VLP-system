package com.assignment.service.Model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OwnersDto {
    private String OwnerID;
    private String name;
    private String email;
    private String address;
    private int phone;

}
