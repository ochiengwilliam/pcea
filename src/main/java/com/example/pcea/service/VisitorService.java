package com.example.pcea.service;

import com.example.pcea.entities.Visitor;
import com.example.pcea.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Optional<Visitor> getVisitorById(Long id) {
        return visitorRepository.findById(id);
    }

    public Optional<Visitor> updateVisitor(Long id, Visitor updatedVisitor) {
        Optional<Visitor> existingVisitor = visitorRepository.findById(id);
        if (existingVisitor.isPresent()) {
            Visitor visitor = existingVisitor.get();
            visitor.setFirstName(updatedVisitor.getFirstName());
            visitor.setMiddleName(updatedVisitor.getMiddleName());
            visitor.setSurname(updatedVisitor.getSurname());
            visitor.setNationalId(updatedVisitor.getNationalId());
            visitor.setMobile(updatedVisitor.getMobile());
            visitor.setAddress(updatedVisitor.getAddress());
            visitor.setGender(updatedVisitor.getGender());
            return Optional.of(visitorRepository.save(visitor));
        } else {
            return Optional.empty();
        }
    }


    public boolean deleteVisitor(Long id) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        if (visitor.isPresent()) {
            visitorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public long getVisitorCount() {
        return visitorRepository.count();
    }
}
