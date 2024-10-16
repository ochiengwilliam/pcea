package com.example.pcea.repository;

import com.example.pcea.entities.MemberCardLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCardLinkRepository extends JpaRepository<MemberCardLink, Long> {

}
