package com.example.pcea.controller;

import com.example.pcea.entities.ChildInformation;
import com.example.pcea.service.ChildInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ChildInformationController {

    @Autowired
    private ChildInformationService childInformationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/children")
    public ResponseEntity<List<ChildInformation>> createChildren(@RequestBody List<ChildInformation> childInformationList) {
        List<ChildInformation> savedChildren = childInformationService.saveAllChildren(childInformationList);
        return ResponseEntity.ok(savedChildren);
    }

    @GetMapping
    public ResponseEntity<List<ChildInformation>> getAllChildren() {
        List<ChildInformation> children = childInformationService.getAllChildren();
        return ResponseEntity.ok(children);
    }
}
