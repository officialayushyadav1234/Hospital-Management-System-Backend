package com.ayush.Hospital_Management_System_Spring_boot.Dao;

import java.util.List;
import java.util.Optional;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;

public interface DoctorsDao {

	Doctor saveDoctorDao(Doctor doctor);

	List<Doctor> getAllDoctorDao();

	// FIX: Changed long to Integer to match Entity
	Optional<Doctor> getDoctorByIdDao(Integer id);

	Doctor findByEmailDao(String email);

	Doctor findByContactNumberDao(String contactNumber);

	List<Doctor> findBySpecializationDao(String specialization);

	boolean existsByEmailDao(String email);

	boolean existsByContactNumberDao(String contactNumber);

	// FIX: Changed Long to Integer
	boolean authenticateDoctorDao(Integer doctorId, String password);

	// FIX: Changed long to Integer
	void deleteDoctorById(Integer id);
}