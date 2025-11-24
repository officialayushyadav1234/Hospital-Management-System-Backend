package com.ayush.Hospital_Management_System_Spring_boot.Service;

import java.util.List;
import java.util.Optional;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Patient;

public interface PatientsService {

	Patient savePatient(Patient patient);

	List<Patient> getAllPatient();

	Optional<Patient> getPatientById(int id);

	Patient findByContactNumber(String contactNumber);

	Patient findByEmail(String email);

	boolean existsByEmail(String email);

	boolean authenticatePatientCredentials(int patientId, String password);
}
