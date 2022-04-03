package com.jee.cabinetSpring.controller;

import com.jee.cabinetSpring.exception.ResourceNotFound;
import com.jee.cabinetSpring.model.Doctor;
import com.jee.cabinetSpring.responses.MessageResponse;
import com.jee.cabinetSpring.service.DoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
@Api(description = "this is a Doctor controller")
@CrossOrigin("*")
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
	// @PathVariable("id") : il est obligatoire d'écrire
	// le param "id" dans le PathVariable si le nom du param est different de celui
	// dans le PutMapping
	public Doctor find_doctor(
			@ApiParam(name = "id", value = "Id of the doctor. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id)
			throws ResourceNotFound {
		Doctor d = agentDoctor.findById(id);

		return d;
	}

//    @DeleteMapping("/{id}")
//    public Map<String,Boolean> delete_doctor(@PathVariable("id") Long id) throws ResourceNotFound
//    {
//        agentDoctor.delete_doctor(id);
//        Map<String,Boolean> res=new HashMap<>();
//        res.put("deleted",Boolean.TRUE);
//        return res;
//    }

	@ApiOperation(value = "delete doctor by id")
	@DeleteMapping("/{id}")
	public MessageResponse delete(
			@ApiParam(name = "id", value = "Id of the doctor to be deleted. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id)
			{
		return agentDoctor.delete(id);
	}

	@ApiOperation(value = "add new doctor")
	@PostMapping
	// @RequestBody : le contenue de body de la requte va etre convertie en objet
	// doctor
	public MessageResponse add_doctor(@RequestBody Doctor doctor) {
		return agentDoctor.save(doctor);
	}

	@ApiOperation(value = "edit doctor by id")
	@PutMapping("/{id}")
	public MessageResponse update_doctor(
			@ApiParam(name = "id", value = "Id of the doctor to be update. Cannot be empty.", example = "1", required = true) @PathVariable("id") Long id,
			@RequestBody Doctor doctor) {
		Doctor d = agentDoctor.findById(id);
		d.setFirstname(doctor.getFirstname());
		d.setLastname(doctor.getLastname());
		d.setEmailAddress(doctor.getEmailAddress());
		d.setSpecialite(doctor.getSpecialite());
		return agentDoctor.update(doctor);
	}
	

}
