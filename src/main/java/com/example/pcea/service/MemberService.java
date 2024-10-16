package com.example.pcea.service;

import com.example.pcea.entities.Member;
import com.example.pcea.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Retrieve all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {
            Member member = existingMember.get();
            member.setFullName(updatedMember.getFullName());
            member.setDob(updatedMember.getDob());
            member.setDistrict(updatedMember.getDistrict());
            member.setMaritalStatus(updatedMember.getMaritalStatus());
            member.setSpouseZPNumber(updatedMember.getSpouseZPNumber());
            member.setSpouseName(updatedMember.getSpouseName());
            member.setNationalID(updatedMember.getNationalID());
            member.setMobileNumber(updatedMember.getMobileNumber());
            member.setCardSerialNumber(updatedMember.getCardSerialNumber());
            member.setHolyCommunionStatus(updatedMember.getHolyCommunionStatus());
            member.setUpdatedAt(updatedMember.getUpdatedAt());
            member.setUpdatedBy(updatedMember.getUpdatedBy());
            return memberRepository.save(member);
        }
        return null;
    }


    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // Find a member by ZP number
    public Optional<Member> getMemberByZpNumber(String zpNumber) {
        return memberRepository.findByZpNumber(zpNumber);
    }

    // Find a member by mobile number
    public Optional<Member> getMemberByMobileNumber(String mobileNumber) {
        return memberRepository.findByMobileNumber(mobileNumber);
    }


    public Optional<Member> getMemberByNationalID(String nationalID) {
        return memberRepository.findByNationalID(nationalID);
    }

    public List<Member> getMembersByDistrict(String district) {
        return memberRepository.findByDistrict(district);
    }


    public boolean existsByZpNumber(String zpNumber) {
        return memberRepository.existsByZpNumber(zpNumber);
    }


    public boolean existsByNationalID(String nationalID) {
        return memberRepository.existsByNationalID(nationalID);
    }
}
