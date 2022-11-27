package com.jee.cabinetSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jee.cabinetSpring.exception.ResourceNotFound;
import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.responses.MessageResponse;
import com.jee.cabinetSpring.service.DoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/doctors")
@Api(description = "this is a Doctor controller")
@CrossOrigin("http://localhost:4200/")
public class DoctorController {

	@Autowired
	DoctorService agentDoctor;

	@ApiOperation(value = "Get All Doctors")
	@GetMapping
	public List<Doctor> dispplay_doctors() {
		return agentDoctor.findAll();
	}

	@ApiOperation(value = "Get Doctor By Id of the Doctor")
	@GetMapping("/{id}")
	public Doctor find_doctor(
			@ApiParam(name = "id", value = "Id of the doctor. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id)
			throws ResourceNotFound {
		Doctor d = agentDoctor.findById(id);

		return d;
	}

	@ApiOperation(value = "delete doctor by id")
	@DeleteMapping("/{id}")
	public MessageResponse delete(
			@ApiParam(name = "id", value = "Id of the doctor to be deleted. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id) {
		return agentDoctor.delete(id);
	}

	@ApiOperation(value = "add new doctor")
	@PostMapping
	public MessageResponse add_doctor(@RequestBody Doctor doctor) {
		return agentDoctor.save(doctor);
	}

	@ApiOperation(value = "edit doctor by id")
	@PutMapping("/{id}")
	public MessageResponse update_doctor(
			@ApiParam(name = "id", value = "Id of the doctor to be update. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id,
			@RequestBody Doctor doctor) {
		return agentDoctor.update(id, doctor);
	}

}
