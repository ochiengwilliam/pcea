package com.example.pcea.service;

import com.example.pcea.entities.VisitorCardLink;
import com.example.pcea.repository.VisitorCardLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorCardLinkService {

    @Autowired
    private VisitorCardLinkRepository repository;


    public List<VisitorCardLink> getAllLinks() {
        return repository.findAll();
    }


    public VisitorCardLink saveLink(VisitorCardLink link) {
        return repository.save(link);
    }

    public void deleteLink(Long id) {
        repository.deleteById(id);
    }

    public Optional<VisitorCardLink> getLinkById(Long id) {
        System.out.println("Fetching VisitorCardLink from database for ID: " + id);
        return repository.findById(id);
    }

    public Optional<VisitorCardLink> updateLink(Long id, VisitorCardLink updatedLink) {
        return repository.findById(id).map(existingLink -> {

            existingLink.setPhoneNo(updatedLink.getPhoneNo());
            existingLink.setCardSerialNo(updatedLink.getCardSerialNo());
            existingLink.setCardLinkStatus(updatedLink.getCardLinkStatus());
            existingLink.setAssignedDate(updatedLink.getAssignedDate());
            existingLink.setDeAssignedDate(updatedLink.getDeAssignedDate());
            existingLink.setIssues(updatedLink.getIssues());


            return repository.save(existingLink);
        });
    }
}
