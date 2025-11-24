package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.DoctorNote;
import com.ayush.Hospital_Management_System_Spring_boot.Service.DoctorNoteService;

@RestController
@RequestMapping("/api/doctor-notes")
@CrossOrigin(value = "http://localhost:5173")
public class DoctorNoteController {

	@Autowired
	private DoctorNoteService doctorNoteService;

	// Add a new note
	@PostMapping
	public ResponseEntity<?> addDoctorNote(@RequestBody DoctorNote doctorNote) {
		try {
			DoctorNote savedNote = doctorNoteService.saveDoctorNote(doctorNote);
			return ResponseEntity.ok(savedNote);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// Get all notes by patient ID
	@GetMapping("/patient/{patientId}")
	public List<DoctorNote> getDoctorNotesByPatient(@PathVariable Integer patientId) {
		return doctorNoteService.getNotesByPatientId(patientId);
	}
}
