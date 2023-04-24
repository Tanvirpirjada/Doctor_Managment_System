package com.example.Doctor_Managment_API.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Integer doctor_id;
    private String doctor_name;
    private String phone_number;
    private String speciality;
}
