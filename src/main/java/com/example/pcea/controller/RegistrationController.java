package com.example.pcea.controller;

import com.example.pcea.entities.Registration;
import com.example.pcea.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/registration")
    public ResponseEntity<Registration> register(@RequestBody Registration registration) {
        Registration savedRegistration = registrationRepository.save(registration);
        return ResponseEntity.ok(savedRegistration);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/registration/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        return registration.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/registration/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long id, @RequestBody Registration updatedRegistration) {
        Optional<Registration> existingRegistration = registrationRepository.findById(id);
        if (existingRegistration.isPresent()) {
            Registration registration = existingRegistration.get();


            if (updatedRegistration.getFirstName() != null) {
                registration.setFirstName(updatedRegistration.getFirstName());
            }
            if (updatedRegistration.getMiddleName() != null) {
                registration.setMiddleName(updatedRegistration.getMiddleName());
            }
            if (updatedRegistration.getSurname() != null) {
                registration.setSurname(updatedRegistration.getSurname());
            }
            if (updatedRegistration.getNationalId() != null) {
                registration.setNationalId(updatedRegistration.getNationalId());
            }
            if (updatedRegistration.getMobile() != null) {
                registration.setMobile(updatedRegistration.getMobile());
            }
            if (updatedRegistration.getZpNo() != null) {
                registration.setZpNo(updatedRegistration.getZpNo());
            }

            if (updatedRegistration.getMaritalStatus() != null) {
                registration.setMaritalStatus(updatedRegistration.getMaritalStatus());
            }
            if (updatedRegistration.getSpouseName() != null) {
                registration.setSpouseName(updatedRegistration.getSpouseName());
            }
            if (updatedRegistration.getSpouseZpNo() != null) {
                registration.setSpouseZpNo(updatedRegistration.getSpouseZpNo());
            }

            Registration savedRegistration = registrationRepository.save(registration);
            return ResponseEntity.ok(savedRegistration);
        }
        return ResponseEntity.notFound().build();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/registration")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
        return ResponseEntity.ok(registrations);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/registration/count")
    public ResponseEntity<Long> getTotalRegistrations() {
        long count = registrationRepository.count();
        return ResponseEntity.ok(count);
    }

}
