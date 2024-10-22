package com.example.pcea.repository;

import com.example.pcea.entities.ChildInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildInformationRepository extends JpaRepository<ChildInformation, Long> {
}