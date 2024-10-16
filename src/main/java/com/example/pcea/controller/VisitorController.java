package com.example.pcea.controller;

import com.example.pcea.entities.Visitor;
import com.example.pcea.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/visitors")
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/visitors")
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/visitors/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        Optional<Visitor> visitor = visitorService.getVisitorById(id);
        return visitor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/visitors/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id, @RequestBody Visitor updatedVisitor) {
        Optional<Visitor> savedVisitor = visitorService.updateVisitor(id, updatedVisitor);
        return savedVisitor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // New DELETE endpoint
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/visitors/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        boolean isDeleted = visitorService.deleteVisitor(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/visitors/count")
    public ResponseEntity<Long> getVisitorCount() {
        long count = visitorService.getVisitorCount();
        return ResponseEntity.ok(count);
    }

}
