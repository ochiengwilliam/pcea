package com.example.pcea.controller;

import com.example.pcea.entities.MemberCardLink;
import com.example.pcea.service.MemberCardLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member-card-link")
@CrossOrigin(origins = "*")
public class MemberCardLinkController {

    @Autowired
    private MemberCardLinkService service;

    @GetMapping
    public List<MemberCardLink> getAllMemberCardLinks() {
        return service.getAllMemberCardLinks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberCardLink> getMemberCardLinkById(@PathVariable Long id) {
        Optional<MemberCardLink> memberCardLink = service.getMemberCardLinkById(id);
        return memberCardLink.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MemberCardLink> createOrUpdateMemberCardLink(@RequestBody MemberCardLink memberCardLink) {
        try {
            MemberCardLink savedMemberCardLink = service.saveMemberCardLink(memberCardLink);
            return ResponseEntity.ok(savedMemberCardLink);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<MemberCardLink> updateMemberCardLink(@PathVariable Long id, @RequestBody MemberCardLink updatedMemberCardLink) {
        Optional<MemberCardLink> existingMemberCardLink = service.getMemberCardLinkById(id);
        if (existingMemberCardLink.isPresent()) {
            MemberCardLink memberCardLinkToUpdate = existingMemberCardLink.get();


            memberCardLinkToUpdate.setPhoneNo(updatedMemberCardLink.getPhoneNo());
            memberCardLinkToUpdate.setCardSerialNo(updatedMemberCardLink.getCardSerialNo());
            memberCardLinkToUpdate.setCardLinkStatus(updatedMemberCardLink.getCardLinkStatus());
            memberCardLinkToUpdate.setAssignedDate(updatedMemberCardLink.getAssignedDate());
            memberCardLinkToUpdate.setDeAssignedDate(updatedMemberCardLink.getDeAssignedDate());
            memberCardLinkToUpdate.setIssues(updatedMemberCardLink.getIssues());


            MemberCardLink savedMemberCardLink = service.saveMemberCardLink(memberCardLinkToUpdate);
            return ResponseEntity.ok(savedMemberCardLink);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
