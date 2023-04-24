package com.example.Doctor_Managment_API.service;


import com.example.Doctor_Managment_API.dao.IDoctorRepository;
import com.example.Doctor_Managment_API.dao.IPatientRepository;
import com.example.Doctor_Managment_API.model.Doctor;
import com.example.Doctor_Managment_API.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

     @Autowired
    IDoctorRepository doctorRepository;

     @Autowired
    IPatientRepository patientRepository;
    public void saveDoctor(Doctor doctor) {
         doctorRepository.save(doctor);
    }

    public List<Doctor> getdoctor(Integer id) {
    List<Doctor> doctorList = new ArrayList<>();
    Patient patient=patientRepository.findById(id).get();

    String city=patient.getCity();
    String Symptoms= patient.getSymptoms();


            if(Symptoms.equals("Arthritis") || Symptoms.equals("Back Pain") || Symptoms.equals(" Tissue injuries")){
                List<Doctor>  list=doctorRepository.findBySymptoms(city,"Orthopedic");
                doctorList=list;
            }
            else if(Symptoms.equals("Dysmenorrhea")){
                List<Doctor>  list=doctorRepository.findBySymptoms(city,"Gynecology");
                doctorList=list;
            }
            else if(Symptoms.equals("Skin infection") || Symptoms.equals("skin burn") ){
                List<Doctor> list=doctorRepository.findBySymptoms(city,"Dermatology");
                doctorList=list;
            }
            else if(Symptoms.equals("Ear pain")) {
                List<Doctor> list = doctorRepository.findBySymptoms(city, "ENT");
                doctorList=list;
            }


        return doctorList;
    }

    public void deletedoctor(Integer id) {
        Doctor doctor=doctorRepository.findById(id).get();
        doctorRepository.delete(doctor);
    }

    public List<Doctor> getalldoctors() {
        return doctorRepository.findAll();
    }
}
