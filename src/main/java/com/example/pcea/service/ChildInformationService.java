package com.example.pcea.service;

import com.example.pcea.entities.ChildInformation;
import com.example.pcea.repository.ChildInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildInformationService {

    @Autowired
    private ChildInformationRepository childInformationRepository;

    public ChildInformation saveChildInformation(ChildInformation childInformation) {
        return childInformationRepository.save(childInformation);
    }

    public List<ChildInformation> getAllChildren() {
        return childInformationRepository.findAll();
    }

    // New method to save a list of ChildInformation objects
    public List<ChildInformation> saveAllChildren(List<ChildInformation> childInformationList) {
        return childInformationRepository.saveAll(childInformationList);
    }
}
