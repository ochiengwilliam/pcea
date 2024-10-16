package com.example.pcea.repository;

import com.example.pcea.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {


    Optional<Visitor> findByNationalId(String nationalId);

}
