# Doctor-Patient Platform

* A backend system built using Spring Boot and Hibernate to handle operations related to doctors and patients. This project includes APIs to add doctors and patients, along with an API to suggest a doctor based on the patient's symptom and location.

## Entities

* Doctor

In our database, we have the following fields for a doctor:

Name (String)
City (String) - can only have values: Delhi, Noida, Faridabad
Email (String) - should be a valid email address
Phone Number (String) - should be at least 10 digits
Speciality (String) - can only have values: Orthopedic, Gynecology, Dermatology, ENT specialist


* Patient

In our database, we have the following fields for a patient:

Name (String)
City (String)
Email (String) - should be a valid email address
Phone Number (String) - should be at least 10 digits
Symptom (String) - can only have values: Arthritis, Back Pain, Tissue injuries (comes under Orthopedic speciality), Dysmenorrhea (comes under Gynecology speciality), Skin infection, skin burn (comes under Dermatology speciality), Ear pain (comes under ENT speciality)

## Validations

The following validations are in place for the fields:

Name (should be at least 3 characters)
City (should be at max 20 characters)
Email (should be a valid email address)
Phone number (should be at least 10 digits)

# ScreenShots

![Screenshot (158)](https://user-images.githubusercontent.com/111841729/233902079-f0447815-8392-4f15-bd90-919e58660c1f.png)
![Screenshot (150)](https://user-images.githubusercontent.com/111841729/233902103-395156e7-0c25-4460-8c97-0891530129b0.png)
![Screenshot (151)](https://user-images.githubusercontent.com/111841729/233902115-67092265-e3e1-42a1-966b-3e66ad2652ec.png)
![Screenshot (152)](https://user-images.githubusercontent.com/111841729/233902130-744e4dd1-b176-4707-a5bc-36099eb4d59c.png)
![Screenshot (153)](https://user-images.githubusercontent.com/111841729/233902146-5c1d18ed-c700-44b6-a9b9-2b73bcdd7783.png)
![Screenshot (154)](https://user-images.githubusercontent.com/111841729/233902158-438a204b-1d4d-4272-a7ad-69af74132b65.png)
![Screenshot (155)](https://user-images.githubusercontent.com/111841729/233902171-ca22fcb6-3fc0-4bde-af63-ec9618990a15.png)
![Screenshot (156)](https://user-images.githubusercontent.com/111841729/233902187-20ecce98-242e-49e2-8b90-326fe6999c33.png)
![Screenshot (157)](https://user-images.githubusercontent.com/111841729/233902243-2b983537-828d-4ce2-89d4-05ab7f2fdcbf.png)
![Screenshot (159)](https://user-images.githubusercontent.com/111841729/233902313-186dd7c5-e2d7-4a67-a790-a9f46504ccaf.png)
![Screenshot (160)](https://user-images.githubusercontent.com/111841729/233902329-b069bc6f-49ca-4fd9-bf19-291d8694fbb7.png)

## APIs
The following APIs are available in this project:

Doctor APIs
POST /create - Add a new doctor
DELETE /deletedoctor/id/{id}- Delete an existing doctor by ID
GET /getalldoctors- get all doctors

Patient APIs
POST /createPatient - Add a new patient
DELETE /deletePatient/{id} - Delete an existing patient by ID
GET /getPatient - By id or all


* Suggestion API
GET /getdoctor/suggestions?patientId={id} - Get a suggestion for a doctor based on the patient's symptom and location. Returns the doctor's name, email, phone number, and speciality.

* Swagger API url
http://localhost:8080/swagger-ui.html#/patient-controller

## Edge Cases

If there isn't any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response should be “We are still waiting to expand to your location”
If there isn't any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”

## Tools Used

Spring Boot Framework
Hibernate
Swagger (for API documentation)


## Getting Started

Clone the repository
Open the project in your preferred IDE
Run the project using mvn spring-boot:run or by running the DoctorManagmentApiApplication class
The APIs are now available on localhost:8080
