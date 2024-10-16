package com.example.pcea.repository;

import com.example.pcea.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {


    Optional<Registration> findByNationalId(String nationalId);

    Optional<Registration> findByMobile(String mobile);


    List<Registration> findByDistrict(String district);


    boolean existsByNationalId(String nationalId);


    boolean existsByMobile(String mobile);


    List<Registration> findBySpouseZpNoIsNull();


    List<Registration> findBySpouseZpNoIsNotNull();


    Optional<Registration> findBySpouseZpNo(String spouseZpNo);
}
