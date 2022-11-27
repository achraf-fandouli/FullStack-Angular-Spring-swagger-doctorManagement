package com.jee.cabinetSpring.service;

import java.util.List;

import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.responses.MessageResponse;

public interface DoctorService {
    public MessageResponse save(Doctor doctor);
    public MessageResponse delete(Long id);
    public MessageResponse update(Long id,Doctor user);
    public List<Doctor> findAll();
    public Doctor findById(Long id);
    public boolean existById(Long id);	
}
