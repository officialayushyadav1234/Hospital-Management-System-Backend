package com.ayush.Hospital_Management_System_Spring_boot.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;
import com.ayush.Hospital_Management_System_Spring_boot.Repository.DoctorReposetory;

@Repository
public class DoctorDao implements DoctorsDao {

	@Autowired
	private DoctorReposetory reposetory;

	@Override
	public Doctor saveDoctorDao(Doctor doctor) {
		return reposetory.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctorDao() {
		return reposetory.findAll();
	}

	@Override
	public Optional<Doctor> getDoctorByIdDao(Integer id) {
		return reposetory.findById(id);
	}

	@Override
	public Doctor findByEmailDao(String email) {
		return reposetory.findByEmail(email);
	}

	@Override
	public Doctor findByContactNumberDao(String contactNumber) {
		return reposetory.findByContactNumber(contactNumber);
	}

	@Override
	public List<Doctor> findBySpecializationDao(String specialization) {
		return reposetory.findBySpecialization(specialization);
	}

	@Override
	public boolean existsByEmailDao(String email) {
		return reposetory.existsByEmail(email);
	}

	@Override
	public boolean existsByContactNumberDao(String contactNumber) {
		return reposetory.existsByContactNumber(contactNumber);
	}

	@Override
	public boolean authenticateDoctorDao(Integer doctorId, String password) {
		// Ensure your Repository method signature also accepts Integer if needed
		Optional<Doctor> doctor = reposetory.findByDoctorIdAndPassword(doctorId, password);
		return doctor.isPresent();
	}

	@Override
	public void deleteDoctorById(Integer id) {
		reposetory.deleteById(id);
	}
}