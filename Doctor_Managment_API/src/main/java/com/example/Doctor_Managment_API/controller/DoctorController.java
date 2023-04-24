package com.example.Doctor_Managment_API.controller;

import com.example.Doctor_Managment_API.dto.DoctorDto;
import com.example.Doctor_Managment_API.model.Doctor;
import com.example.Doctor_Managment_API.service.DoctorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {


    @Autowired
    DoctorService doctorService;

    @GetMapping("getalldoctors")
    public ResponseEntity getalldoctors(){
        List<Doctor> doctorList=doctorService.getalldoctors();
        return new ResponseEntity<>(doctorList.toString(),HttpStatus.OK);
    }

    @GetMapping("getdoctor")
    public ResponseEntity getdoctor(@RequestParam Integer patientId){

        List<Doctor> doctors=doctorService.getdoctor(patientId);
        if(doctors.isEmpty()){
            return new ResponseEntity<>("We are still waiting to expand to your location or There isn’t any doctor present at your location for your symptom",HttpStatus.OK);
        }
        return new ResponseEntity(doctors.toString(),HttpStatus.OK);
    }

    @DeleteMapping("deletedoctor/id/{id}")
    public ResponseEntity deletedoctor(@PathVariable Integer id){
        doctorService.deletedoctor(id);
        return new ResponseEntity("doctor delete successfully", HttpStatus.NO_CONTENT);
    }
    @PostMapping("create")
    public ResponseEntity createDoctor(@RequestBody String requestBody){
        JSONObject jsonObject=new JSONObject(requestBody);
        Doctor doctor=setDoctor(jsonObject);
        List<String> errorList=new ArrayList<>();
        errorList=validateEntity(jsonObject);
        if(errorList.isEmpty()){
            doctorService.saveDoctor(doctor);
        }
        else{
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("doctor saved",HttpStatus.CREATED);
    }

    private Doctor setDoctor(JSONObject jsonObject) {
        Doctor doctor=new Doctor();

        if(jsonObject.has("speciality")){
            doctor.setSpeciality(jsonObject.getString("speciality"));
        }
        if(jsonObject.has("doctor_id")){
            doctor.setDoctor_id(Integer.parseInt(jsonObject.getString("doctor_id")));
        }

        doctor.setDoctor_name(jsonObject.getString("doctor_name"));
        doctor.setCity(jsonObject.getString("city"));
        doctor.setPhone_number(jsonObject.getString("phone_number"));
        doctor.setEmail(jsonObject.getString("email"));

        return doctor;
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

        if(json.has("doctor_name")){
            String name=json.getString("doctor_name");
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
