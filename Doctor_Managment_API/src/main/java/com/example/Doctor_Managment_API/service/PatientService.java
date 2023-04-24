package com.example.Doctor_Managment_API.service;


import com.example.Doctor_Managment_API.dao.IPatientRepository;
import com.example.Doctor_Managment_API.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepository patientRepository;
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getPatients(Integer id) {
        List<Patient> patientList;
        if(id==null){
            patientList=patientRepository.findAll();
        }
        else{
            patientList=new ArrayList<>();
            patientList.add(patientRepository.findById(id).get());
        }
        return patientList;
    }

    public void deletePatient(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        patientRepository.delete(patient);
    }
}
