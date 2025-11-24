package com.ayush.Hospital_Management_System_Spring_boot.Service;

import java.util.List;
import java.util.Optional;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;

public interface DoctorsService {

	Doctor saveDoctor(Doctor doctor);

	List<Doctor> getAllDoctor();

	// FIX: Changed long to Integer
	Optional<Doctor> getDoctorById(Integer id);

	// --- NEW METHOD FOR UPDATE ---
	Doctor updateDoctor(Integer id, Doctor doctor);

	Doctor findByEmail(String email);

	Doctor findByContactNumber(String contactNumber);

	List<Doctor> findBySpecialization(String specialization);

	boolean existsByEmail(String email);

	boolean existsByContactNumber(String contactNumber);

	// FIX: Changed Long to Integer
	boolean authenticateDoctor(Integer doctorId, String password);

	// FIX: Changed long to Integer
	boolean deleteDrById(Integer id);
}