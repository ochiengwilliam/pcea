package com.example.pcea.controller;

import com.example.pcea.entities.District;
import com.example.pcea.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(origins = "http://localhost:3000")
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;


    @PostMapping("/add")
    public ResponseEntity<Object> createDistrict(@RequestBody District district) {
        district.setCreatedAt(LocalDateTime.now());
        district.setUpdatedAt(  LocalDateTime.now());
        District savedDistrict = districtRepository.save(district);
        return ResponseEntity.ok(savedDistrict);
    }


    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtRepository.findAll();
        return ResponseEntity.ok(districts);
    }


    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
        Optional<District> district = districtRepository.findById(id);
        return district.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTotalDistricts() {
        long count = districtRepository.count();
        return ResponseEntity.ok(count);
    }



    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Long id, @RequestBody District updatedDistrict) {
        Optional<District> districtOptional = districtRepository.findById(id);

        if (districtOptional.isPresent()) {
            District existingDistrict = districtOptional.get();
            existingDistrict.setDistrictName(updatedDistrict.getDistrictName());
            existingDistrict.setElderZP(updatedDistrict.getElderZP());
            existingDistrict.setUpdatedBy(updatedDistrict.getUpdatedBy());
            existingDistrict.setUpdatedAt(LocalDateTime.now());
            District savedDistrict = districtRepository.save(existingDistrict);
            return ResponseEntity.ok(savedDistrict);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
