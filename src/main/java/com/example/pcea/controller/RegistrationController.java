package com.example.pcea.controller;

import com.example.pcea.entities.Registration;
import com.example.pcea.repository.RegistrationRepository;
import com.example.pcea.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/registration")
    public ResponseEntity<?> register(@RequestBody Registration registration) {
        try {
            // Use the service method to save the registration and handle validation
            Registration savedRegistration = registrationService.saveRegistration(registration);
            return ResponseEntity.ok(savedRegistration);
        } catch (IllegalArgumentException e) {
            // Return a 400 Bad Request if mobile number already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/registration/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Optional<Registration> registration = registrationService.findRegistrationById(id);
        return registration.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/registration/{id}")
    public ResponseEntity<?> updateRegistration(@PathVariable Long id, @RequestBody Registration updatedRegistration) {
        try {
            Optional<Registration> updated = registrationService.updateRegistration(id, updatedRegistration);
            return updated.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            // Return a 400 Bad Request if the mobile number is already in use
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
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

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/registration/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        if (registration.isPresent()) {
            registrationRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
