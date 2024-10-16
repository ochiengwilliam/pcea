package com.example.pcea.repository;

import com.example.pcea.entities.Elder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElderRepository extends JpaRepository<Elder, Long> {


    List<Elder> findByName(String name);


    List<Elder> findByRole(String role);


    List<Elder> findByElderZP(String elderZP);
}
