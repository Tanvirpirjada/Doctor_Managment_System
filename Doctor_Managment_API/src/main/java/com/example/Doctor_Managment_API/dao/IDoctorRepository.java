package com.example.Doctor_Managment_API.dao;

import com.example.Doctor_Managment_API.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {

   @Query(value = "select * from doctor_table where city = :newCity && speciality = :spec", nativeQuery = true)
   public List<Doctor> findBySymptoms(String newCity,String spec);
}
