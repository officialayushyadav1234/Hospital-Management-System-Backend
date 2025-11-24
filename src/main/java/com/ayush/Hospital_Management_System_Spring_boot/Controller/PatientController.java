package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Patient;
import com.ayush.Hospital_Management_System_Spring_boot.Service.PatientsService;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(value = "http://localhost:5173")
public class PatientController {

	@Autowired
	private PatientsService service;

	@PostMapping
	public Patient savePatientController(@RequestBody Patient patient) {
		System.out.println(patient);
		return service.savePatient(patient);
	}

	@GetMapping
	public List<Patient> getAllPatientController() {
		return service.getAllPatient();
	}

	// UPDATED: Changed int to Integer to prevent crashes if ID is null
	@GetMapping(value = "/{id}")
	public Optional<Patient> getPatientByIdController(@PathVariable Integer id) {
		if (id == null) {
			return Optional.empty();
		}
		return service.getPatientById(id);
	}

	@GetMapping(value = "/contactNumber/{contactNumber}")
	public Patient findByContactNumberController(@PathVariable String contactNumber) {
		return service.findByContactNumber(contactNumber);
	}

	@GetMapping(value = "/email/{email}")
	public Patient findByEmailController(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@PostMapping(value = "/exists/{email}")
	public boolean existsByEmailController(@PathVariable String email) {
		return service.existsByEmail(email);
	}

	// UPDATED: Changed int to Integer to fix "MethodArgumentTypeMismatchException"
	@PostMapping(value = "/auth")
	public boolean authenticatePatientCredentialsController(@RequestParam(required = false) Integer patientId,
			@RequestParam String password) {

		// If patientId comes in as null, return false immediately
		if (patientId == null) {
			return false;
		}

		return service.authenticatePatientCredentials(patientId, password);
	}
}