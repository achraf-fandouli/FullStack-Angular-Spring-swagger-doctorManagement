package com.jee.cabinetSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.repository.DoctorRepository;
import com.jee.cabinetSpring.responses.MessageResponse;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Transactional
	@Override
	public MessageResponse save(Doctor doctor) {

		boolean exist = doctorRepository.existsByEmailAddress(doctor.getEmailAddress());
		if (exist) {
			return new MessageResponse(false, "Attention", "email deja existe");
		}
		
		exist = doctorRepository.existsByFirstname(doctor.getFirstname());
		if (exist) {
			return new MessageResponse(false, "Attention", "le nom de docteur deja existe");
		}
		doctorRepository.save(doctor);
		return new MessageResponse(true, "success", "operation effectuee");

	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		if (findById(id) == null) {
			return new MessageResponse(false, "Attention", "id n'existe pas");
		}
		doctorRepository.deleteById(id);
		return new MessageResponse(true, "success", "operation effectuee");
	}

	@Transactional
	@Override
	public MessageResponse update(Long id, Doctor doctor) {
		if (existById(id)==false) {
			return new MessageResponse(false, "Attention ", "doctor n'existe pas");
		}
		
		if (findById(doctor.getId()) == null) {
			return new MessageResponse(false, "Attention ", "doctor n'existe pas");
		}
//		if (!exist) {
//			exist = doctorRepository.existsByEmailAddress(doctor.getEmailAddress());
//			if (exist) {
//				return new MessageResponse(false, "attention", "Email existe déja");
//			}
//			exist = doctorRepository.existsByIdAndFirstname(doctor.getId(), doctor.getFirstname());
//			if (!exist) {
//				exist = doctorRepository.existsByFirstname(doctor.getFirstname());
//				if (exist) {
//					return new MessageResponse(false, "Attention", "firstname doctor deja existe");
//				}
//			}
//		}
		Doctor d = findById(id);
		d.setFirstname(doctor.getFirstname());
		d.setLastname(doctor.getLastname());
		d.setEmailAddress(doctor.getEmailAddress());
		d.setSpecialite(doctor.getSpecialite());
		
		doctorRepository.save(d);
		return new MessageResponse(true, "Success", "operation reussi");
		
	}
		

	@Transactional(readOnly = true)
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Doctor findById(Long id) {
		return doctorRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean existById(Long id) {
		return doctorRepository.existsById(id);
	}
}
