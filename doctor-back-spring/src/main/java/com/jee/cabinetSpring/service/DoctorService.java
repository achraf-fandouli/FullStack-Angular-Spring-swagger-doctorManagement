package com.jee.cabinetSpring.service;

import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.responses.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public MessageResponse save(Doctor doctor);
    public MessageResponse delete(Long id);
    public MessageResponse update(Doctor user);
    public List<Doctor> findAll();
    public Doctor findById(Long id);
    
//    public Doctor add_doctor(Doctor d);
//    public Optional<Doctor> find_doctor(Long id);
//    public void delete_doctor(Long id);
//    public Doctor update_doctor(Doctor d);
//    public List<Doctor> findAll();
//    //nouvelle mehtode
//    public List<Doctor> search_specialite(String spec);
//    public List<Doctor> advancedSeaurch(String spec,String pseudo);
	
}
