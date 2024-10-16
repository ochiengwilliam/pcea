package com.example.pcea.controller;

import com.example.pcea.entities.Elder;
import com.example.pcea.service.ElderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elders")
public class ElderController {

    @Autowired
    private ElderService elderService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Elder> createElder(@RequestBody Elder elder) {
        Elder createdElder = elderService.createElder(elder);
        return ResponseEntity.ok(createdElder);
    }


    @GetMapping
    public ResponseEntity<List<Elder>> getAllElders() {
        List<Elder> elders = elderService.getAllElders();
        return ResponseEntity.ok(elders);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Elder> getElderById(@PathVariable Long id) {
        Optional<Elder> elder = elderService.getElderById(id);
        if (elder.isPresent()) {
            return ResponseEntity.ok(elder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalElders() {
        long count = elderService.getElderCount();
        return ResponseEntity.ok(count);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Elder> updateElder(@PathVariable Long id, @RequestBody Elder updatedElder) {
        Optional<Elder> elderOptional = elderService.getElderById(id);

        if (elderOptional.isPresent()) {
            Elder existingElder = elderOptional.get();

            existingElder.setName(updatedElder.getName());
            existingElder.setAge(updatedElder.getAge());
            existingElder.setRole(updatedElder.getRole());

            Elder savedElder = elderService.updateElder(existingElder);
            return ResponseEntity.ok(savedElder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
