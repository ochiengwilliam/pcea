package com.example.pcea.service;

import com.example.pcea.entities.Registration;
import com.example.pcea.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration saveRegistration(Registration registration) {
        // Check if a registration with the same mobile number already exists
        if (registrationRepository.existsByMobile(registration.getMobile())) {
            // Handle the case where the mobile number is already in use
            throw new IllegalArgumentException("Mobile number already in use");
        }

        // If mobile number is unique, save the registration
        return registrationRepository.save(registration);
    }

    public Optional<Registration> updateRegistration(Long id, Registration updatedRegistration) {
        Optional<Registration> existingRegistrationOpt = registrationRepository.findById(id);

        if (existingRegistrationOpt.isPresent()) {
            Registration existingRegistration = existingRegistrationOpt.get();

            if (updatedRegistration.getFirstName() != null) {
                existingRegistration.setFirstName(updatedRegistration.getFirstName());
            }
            if (updatedRegistration.getMiddleName() != null) {
                existingRegistration.setMiddleName(updatedRegistration.getMiddleName());
            }
            if (updatedRegistration.getSurname() != null) {
                existingRegistration.setSurname(updatedRegistration.getSurname());
            }
            if (updatedRegistration.getNationalId() != null) {
                existingRegistration.setNationalId(updatedRegistration.getNationalId());
            }

            if (updatedRegistration.getMobile() != null) {
                // Check if the new mobile number is already in use by another registration
                if (registrationRepository.existsByMobile(updatedRegistration.getMobile()) &&
                        !existingRegistration.getMobile().equals(updatedRegistration.getMobile())) {
                    throw new IllegalArgumentException("Mobile number already in use");
                }

                existingRegistration.setMobile(updatedRegistration.getMobile());
            }

            if (updatedRegistration.getSpouseZpNo() != null) {
                existingRegistration.setSpouseZpNo(updatedRegistration.getSpouseZpNo());
            }
            if (updatedRegistration.getMaritalStatus() != null) {
                existingRegistration.setMaritalStatus(updatedRegistration.getMaritalStatus());
            }
            if (updatedRegistration.getSpouseName() != null) {
                existingRegistration.setSpouseName(updatedRegistration.getSpouseName());
            }

            return Optional.of(registrationRepository.save(existingRegistration));
        }

        return Optional.empty();
    }

    public Optional<Registration> findRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }
}
