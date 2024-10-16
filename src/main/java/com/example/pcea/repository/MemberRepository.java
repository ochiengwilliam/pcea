package com.example.pcea.repository;

import com.example.pcea.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findByZpNumber(String zpNumber);

    List<Member> findByFullNameContainingIgnoreCase(String fullName);


    Optional<Member> findByMobileNumber(String mobileNumber);


    Optional<Member> findByNationalID(String nationalID);


    List<Member> findByDistrict(String district);


    boolean existsByZpNumber(String zpNumber);


    boolean existsByNationalID(String nationalID);
}
