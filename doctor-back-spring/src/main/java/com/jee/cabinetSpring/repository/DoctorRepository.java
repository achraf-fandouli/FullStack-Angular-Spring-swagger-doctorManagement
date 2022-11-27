package com.jee.cabinetSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jee.cabinetSpring.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	boolean existsByEmailAddress(String emailAddress);

	boolean existsByIdAndEmailAddress(Long id, String email);
	
	boolean existsByFirstname(String firstname);
	
	boolean existsByIdAndFirstname(long id, String fistname);
}
