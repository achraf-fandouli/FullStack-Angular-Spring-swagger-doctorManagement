package com.jee.cabinetSpring.repository;

import com.jee.cabinetSpring.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	boolean existsByEmailAddress(String emailAddress);

	boolean existsByIdAndEmailAddress(Long id, String email);
	
	boolean existsByFirstname(String firstname);
	
	boolean existsByIdAndFirstname(long id, String fistname);
/*
	// select * from doctors where specialite=:spec --> c'est un preparedStatment
	// chaque méthode dans l'interface DoctorRepository sera traduite en classe dans
	// Model
	public List<Doctor> findBySpecialite(String spec);

	@Query(value = "select m from Doctor m where m.specialite =:spec and (m.firstname like :pseudo or m.lastname like :pseudo)")
	// @Param("pseudo") le param 1 va etre remplacer par spec et le 2 param va etre
	// remplacer par pseudo
	public List<Doctor> search(@Param("spec") String spec, @Param("pseudo") String pseudo);
*/
}
