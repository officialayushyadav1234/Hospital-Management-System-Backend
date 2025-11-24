package com.ayush.Hospital_Management_System_Spring_boot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;

@Repository
public interface DoctorReposetory extends JpaRepository<Doctor, Integer> {

	Doctor findByEmail(String email);

	Doctor findByContactNumber(String contactNumber);

	List<Doctor> findBySpecialization(String specialization);

	boolean existsByEmail(String email);

	boolean existsByContactNumber(String contactNumber);

	// FIX 2: Added this method to support your Login/Auth logic
	// This was likely causing the "undefined method" error in DAO
	Optional<Doctor> findByDoctorIdAndPassword(Integer doctorId, String password);
}