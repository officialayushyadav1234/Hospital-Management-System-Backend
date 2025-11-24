package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Appointment;
import com.ayush.Hospital_Management_System_Spring_boot.Service.AppointmentsService;

@RestController
@RequestMapping("/api/appointment") // This is your URL!
@CrossOrigin(origins = "http://localhost:5173") // Fixes CORS for React
public class AppointmentController {

	@Autowired
	private AppointmentsService service;

	@PostMapping
	public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
		try {
			// Validate: Doctor Check
			if (service.isDoctorBooked(appointment.getDoctor(), appointment.getAppointmentDate())) {
				return new ResponseEntity<>("Doctor is already booked on this date.", HttpStatus.BAD_REQUEST);
			}
			// Validate: Patient Check
			if (service.isPatientBooked(appointment.getPatient(), appointment.getAppointmentDate())) {
				return new ResponseEntity<>("Patient already has an appointment on this date.", HttpStatus.BAD_REQUEST);
			}

			Appointment savedAppointment = service.saveAppointment(appointment);
			return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace(); // Helps see errors in Eclipse console
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> list = service.getAllAppointments();
		if (list == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Get appointments by date
	@GetMapping(value = "/date")
	public ResponseEntity<List<Appointment>> getAppointmentsByDate(@RequestParam String date) {
		List<Appointment> list = service.getAppointmentsByDate(LocalDate.parse(date));
		return new ResponseEntity<>(list != null ? list : new ArrayList<>(), HttpStatus.OK);
	}

	// Update an existing appointment
	@PutMapping("/{appointmentId}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer appointmentId, // Changed int to Integer
																								// for safety
			@RequestBody Appointment updatedAppointment) {

		Appointment updated = service.updateAppointment(appointmentId, updatedAppointment);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@GetMapping(value = "/patientId/{patientId}")
	public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Integer patientId) { // Integer
		List<Appointment> list = service.getAppointmentsByPatientId(patientId);
		return new ResponseEntity<>(list != null ? list : new ArrayList<>(), HttpStatus.OK);
	}

	@GetMapping(value = "/doctorId/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable Integer doctorId) { // Integer
		List<Appointment> list = service.getAppointmentsByDoctorId(doctorId);
		return new ResponseEntity<>(list != null ? list : new ArrayList<>(), HttpStatus.OK);
	}
}