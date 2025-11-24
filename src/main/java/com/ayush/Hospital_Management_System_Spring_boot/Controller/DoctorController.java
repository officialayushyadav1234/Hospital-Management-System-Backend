package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; // Added this
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;
import com.ayush.Hospital_Management_System_Spring_boot.Service.DoctorsService;

@RestController
@RequestMapping(value = "/api/doctor")
@CrossOrigin(value = "http://localhost:5173")
public class DoctorController {

	@Autowired
	private DoctorsService service;

	@PostMapping
	public Doctor saveDoctorController(@RequestBody Doctor doctor) {
		return service.saveDoctor(doctor);
	}

	@GetMapping
	public List<Doctor> getAllDoctorController() {
		return service.getAllDoctor();
	}

	// --- FIX 1: Changed to PathVariable to match React URL ---
	// React calls: /api/doctor/5
	@GetMapping(value = "/{id}")
	public Optional<Doctor> getDoctorByIdController(@PathVariable Integer id) {
		return service.getDoctorById(id);
	}

	// --- FIX 2: Added PUT Method for Editing ---
	@PutMapping(value = "/{id}")
	public ResponseEntity<Doctor> updateDoctorController(@PathVariable Integer id, @RequestBody Doctor doctorDetails) {
		Doctor updatedDoctor = service.updateDoctor(id, doctorDetails);
		return ResponseEntity.ok(updatedDoctor);
	}

	@GetMapping(value = "/email")
	public Doctor findByEmailController(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@GetMapping(value = "/contactNumber")
	public Doctor findByContactNumber(@RequestParam String contactNumber) {
		return service.findByContactNumber(contactNumber);
	}

	@GetMapping(value = "/specialization")
	public List<Doctor> findBySpecializationController(@RequestParam String specialization) {
		return service.findBySpecialization(specialization);
	}

	// Boolean EndPoints

	@PostMapping(value = "/existsByEmail")
	public boolean existsByEmailComtroller(@RequestParam String email) {
		return service.existsByEmail(email);
	}

	@PostMapping(value = "/existsByContactNumber")
	public boolean existsByContactNumberController(@RequestParam String contactNumber) {
		return service.existsByContactNumber(contactNumber);
	}

	// Authenticate (Login)
	@PostMapping("/authenticate")
	public ResponseEntity<Boolean> authenticateDoctor(@RequestParam Integer doctorId, @RequestParam String password) {
		boolean isAuthenticated = service.authenticateDoctor(doctorId, password);
		return ResponseEntity.ok(isAuthenticated);
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteDrByIdController(@PathVariable Integer id) {
		return service.deleteDrById(id);
	}
}