package com.example.Doctor_Managment_API.mapper;


import com.example.Doctor_Managment_API.dto.PatientDto;
import org.mapstruct.Mapper;

@Mapper
public interface IPatientMapper {

    PatientDto PatientTOPatientDto(PatientDto patientDto);
}
