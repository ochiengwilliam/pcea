package com.example.pcea.service;

import com.example.pcea.entities.Elder;
import com.example.pcea.repository.ElderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ElderService {

    @Autowired
    private ElderRepository elderRepository;


    public Elder createElder(Elder elder) {
        elder.setCreatedAt(LocalDateTime.now());
        return elderRepository.save(elder);
    }


    public List<Elder> getAllElders() {
        return elderRepository.findAll();
    }


    public Optional<Elder> getElderById(Long id) {
        return elderRepository.findById(id);
    }


    public Elder updateElder(Elder elder) {
        elder.setUpdatedAt(LocalDateTime.now());
        return elderRepository.save(elder);
    }

    public long getElderCount() {
        return elderRepository.count();
    }
}
