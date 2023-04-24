package com.example.Doctor_Managment_API.dao;

import com.example.Doctor_Managment_API.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {

}
