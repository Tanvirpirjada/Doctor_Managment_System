package com.example.Doctor_Managment_API.controller;


import com.example.Doctor_Managment_API.model.Doctor;
import com.example.Doctor_Managment_API.model.Patient;
import com.example.Doctor_Managment_API.service.PatientService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {


    @Autowired
    PatientService patientService;


    @DeleteMapping("deletePatient/id/{id}")
    public void deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
    }

    @GetMapping("getPatient")
    public ResponseEntity getPatient(@Nullable @RequestParam Integer id){
        List<Patient> patients=patientService.getPatients(id);
        return  new ResponseEntity<>(patients.toString(),HttpStatus.OK);
    }

    @PostMapping("createPatient")
    public ResponseEntity createPatient(@RequestBody String requestBody){
        JSONObject json=new JSONObject(requestBody);
        List<String> errorList=validateEntity(json);
        Patient patient=setPatient(json);
        if(errorList.isEmpty()){
            patientService.savePatient(patient);
        }
        else{
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("patient save successfully",HttpStatus.CREATED);
    }

    private Patient setPatient(JSONObject jsonObject) {

        Patient patient=new Patient();

        if(jsonObject.has("symptoms")){
            patient.setSymptoms(jsonObject.getString("symptoms"));
        }
        if(jsonObject.has("patient_id")){
            patient.setPatient_id(Integer.parseInt(jsonObject.getString("patient_id")));
        }

        patient.setPatient_name((jsonObject.getString("patient_name")));
        patient.setCity(jsonObject.getString("city"));
        patient.setPhone_number(jsonObject.getString("phone_number"));
        patient.setEmail(jsonObject.getString("email"));

        return patient;
    }

    private List<String> validateEntity(JSONObject json) {
        List<String> error=new ArrayList<>();

        if(json.has("email")){
            String email= json.getString("email");
            if(!email.contains("@gmail.com")){
                error.add("email is invalid");
            }
        }
        else{
            error.add("this field is mandatory");
            return error;
        }
        if(json.has("city")){
            String city=json.getString("city");
            if(city.length()>20){
                error.add("should be at max 20 characters");
            }
        }
        else{
            error.add("this field is mandatory");
            return error;
        }

        if(json.has("phone_number")){
            String number=json.getString("phone_number");
            if(number.length()!=10){
                error.add("(should be at least 10 number");
            }
        }
        else{
            error.add("this field is mandatory");
            return error;
        }

        if(json.has("patient_name")){
            String name=json.getString("patient_name");
            if(name.length()<3){
                error.add("name must be least 3 characters");
            }
        }
        else{
            error.add("this field is mandatory");
            return error;
        }
        return error;
    }


}
