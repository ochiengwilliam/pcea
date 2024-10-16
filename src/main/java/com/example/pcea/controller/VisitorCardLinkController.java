package com.example.pcea.controller;

import com.example.pcea.entities.VisitorCardLink;
import com.example.pcea.service.VisitorCardLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/visitor-card-link")
@CrossOrigin(origins = "*")
public class VisitorCardLinkController {

    @Autowired
    private VisitorCardLinkService service;


    @GetMapping
    public ResponseEntity<List<VisitorCardLink>> getAllLinks() {
        try {
            List<VisitorCardLink> links = service.getAllLinks();
            return ResponseEntity.ok(links);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping
    public ResponseEntity<VisitorCardLink> createLink(@RequestBody VisitorCardLink link) {
        try {
            System.out.println("Received request to create VisitorCardLink: " + link);
            VisitorCardLink savedLink = service.saveLink(link);
            System.out.println("Successfully saved VisitorCardLink: " + savedLink);
            return ResponseEntity.ok(savedLink);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<VisitorCardLink> getLinkById(@PathVariable Long id) {
        try {
            System.out.println("Received request to get VisitorCardLink by ID: " + id);
            Optional<VisitorCardLink> link = service.getLinkById(id);
            if (link.isPresent()) {
                System.out.println("Found VisitorCardLink: " + link.get());
                return ResponseEntity.ok(link.get());
            } else {
                System.out.println("VisitorCardLink not found for ID: " + id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }

    }






}