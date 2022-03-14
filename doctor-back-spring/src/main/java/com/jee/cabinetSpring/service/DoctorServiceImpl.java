package com.jee.cabinetSpring.service;

import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository agentDoctor;

    @Override
    public Doctor add_doctor(Doctor d) {
        return agentDoctor.save(d);
    }

    @Override
    public Optional<Doctor> find_doctor(Long id) {
        return agentDoctor.findById(id);
    }

    @Override
    public void delete_doctor(Long id) {
        agentDoctor.deleteById(id);
    }

    @Override
    public Doctor update_doctor(Doctor d) {
        return agentDoctor.save(d);
    }

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) agentDoctor.findAll();
    }

    @Override
    public List<Doctor> search_specialite(String spec) {
        // findBySpecialite c'est la methode dans le repository
        return agentDoctor.findBySpecialite(spec);
    }

    @Override
    public List<Doctor> advancedSeaurch(String spec, String pseudo) {
        return agentDoctor.search(spec,"%"+pseudo+"%");
    }
}
