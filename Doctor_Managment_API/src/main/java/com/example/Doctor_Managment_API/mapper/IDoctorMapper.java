package com.example.Doctor_Managment_API.mapper;



import com.example.Doctor_Managment_API.dto.DoctorDto;
import org.mapstruct.Mapper;

@Mapper
public interface IDoctorMapper {
    DoctorDto DoctorTODoctorDto( DoctorDto doctorDto);
}
