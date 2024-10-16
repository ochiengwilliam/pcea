package com.example.pcea.service;

import com.example.pcea.entities.MemberCardLink;
import com.example.pcea.repository.MemberCardLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberCardLinkService {

    @Autowired
    private MemberCardLinkRepository repository;


    public List<MemberCardLink> getAllMemberCardLinks() {
        return repository.findAll();
    }


    public Optional<MemberCardLink> getMemberCardLinkById(Long id) {
        return repository.findById(id);
    }


    public MemberCardLink saveMemberCardLink(MemberCardLink memberCardLink) {
        return repository.save(memberCardLink);
    }


    public void deleteMemberCardLink(Long id) {
        repository.deleteById(id);
    }


}
