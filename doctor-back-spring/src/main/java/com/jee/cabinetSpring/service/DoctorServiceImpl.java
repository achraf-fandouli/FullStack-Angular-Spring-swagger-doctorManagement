package com.jee.cabinetSpring.service;

import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.repository.DoctorRepository;
import com.jee.cabinetSpring.responses.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
	public MessageResponse update(Doctor doctor) {
		if (findById(doctor.getId()) == null)
			return new MessageResponse(false, "Attention ", "doctor n'existe pas");
		boolean exist = doctorRepository.existsByIdAndEmailAddress(doctor.getId(), doctor.getEmailAddress());
		if (!exist) {
//			exist = doctorRepository.existsByEmailAddress(doctor.getEmailAddress());
//			if (exist) {
//				return new MessageResponse(false, "attention", "Email existe déja");
//			}
			exist = doctorRepository.existsByIdAndFirstname(doctor.getId(),doctor.getFirstname());
			if(!exist) {
				exist = doctorRepository.existsByFirstname(doctor.getFirstname());
			if (exist) {
				return new MessageResponse(false, "Attention", "firstname doctor deja existe");
			}
			}
		}
		doctorRepository.save(doctor);
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

//	@Autowired
//    DoctorRepository agentDoctor;
//
//    @Override
//    public Doctor add_doctor(Doctor d) {
//        return agentDoctor.save(d);
//    }
//
//    @Override
//    public Optional<Doctor> find_doctor(Long id) {
//        return agentDoctor.findById(id);
//    }
//
//    @Override
//    public void delete_doctor(Long id) {
//        agentDoctor.deleteById(id);
//    }
//
//    @Override
//    public Doctor update_doctor(Doctor d) {
//        return agentDoctor.save(d);
//    }
//
//    @Override
//    public List<Doctor> findAll() {
//        return (List<Doctor>) agentDoctor.findAll();
//    }
//
//    @Override
//    public List<Doctor> search_specialite(String spec) {
//        // findBySpecialite c'est la methode dans le repository
//        return agentDoctor.findBySpecialite(spec);
//    }
//
//    @Override
//    public List<Doctor> advancedSeaurch(String spec, String pseudo) {
//        return agentDoctor.search(spec,"%"+pseudo+"%");
//    }
}
