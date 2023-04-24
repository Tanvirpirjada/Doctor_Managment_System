package com.example.Doctor_Managment_API.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Integer patient_id;
    private Integer patient_name;
    private Integer phone_number;
    private List<String> symptoms;

}
