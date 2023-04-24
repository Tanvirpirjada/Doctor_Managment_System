package com.example.Doctor_Managment_API.model;


import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_table")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;
    private String doctor_name;
    private String city;
    private String email;
    private String phone_number;

    private String speciality;
}
