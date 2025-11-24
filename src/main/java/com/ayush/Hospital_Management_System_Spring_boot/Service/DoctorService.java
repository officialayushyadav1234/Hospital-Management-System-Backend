package com.ayush.Hospital_Management_System_Spring_boot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System_Spring_boot.Dao.DoctorsDao;
import com.ayush.Hospital_Management_System_Spring_boot.Entity.Doctor;

@Service
public class DoctorService implements DoctorsService {

	@Autowired
	private DoctorsDao dao;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return dao.saveDoctorDao(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return dao.getAllDoctorDao();
	}

	@Override
	public Optional<Doctor> getDoctorById(Integer id) {
		return dao.getDoctorByIdDao(id);
	}

	// --- NEW UPDATE LOGIC ---
	@Override
	public Doctor updateDoctor(Integer id, Doctor newDetails) {
		// 1. Check if doctor exists
		Optional<Doctor> optionalDoctor = dao.getDoctorByIdDao(id);

		if (optionalDoctor.isPresent()) {
			Doctor existingDoctor = optionalDoctor.get();

			// 2. Update all allowed fields
			existingDoctor.setName(newDetails.getName());
			existingDoctor.setEmail(newDetails.getEmail());
			existingDoctor.setContactNumber(newDetails.getContactNumber());
			existingDoctor.setSpecialization(newDetails.getSpecialization());
			existingDoctor.setExperienceYears(newDetails.getExperienceYears());
			existingDoctor.setClinicAddress(newDetails.getClinicAddress());
			existingDoctor.setAvailableDays(newDetails.getAvailableDays());
			existingDoctor.setConsultationFee(newDetails.getConsultationFee());

			// 3. Update password only if provided
			if (newDetails.getPassword() != null && !newDetails.getPassword().isEmpty()) {
				existingDoctor.setPassword(newDetails.getPassword());
			}

			// 4. Save updated data
			return dao.saveDoctorDao(existingDoctor);
		}
		return null; // Return null if doctor not found
	}

	@Override
	public Doctor findByEmail(String email) {
		if (dao.existsByEmailDao(email)) {
			return dao.findByEmailDao(email);
		}
		return null;
	}

	@Override
	public Doctor findByContactNumber(String contactNumber) {
		if (dao.existsByContactNumberDao(contactNumber)) {
			return dao.findByContactNumberDao(contactNumber);
		}
		return null;
	}

	@Override
	public List<Doctor> findBySpecialization(String specialization) {
		return dao.findBySpecializationDao(specialization);
	}

	@Override
	public boolean existsByEmail(String email) {
		return dao.existsByEmailDao(email);
	}

	@Override
	public boolean existsByContactNumber(String contactNumber) {
		return dao.existsByContactNumberDao(contactNumber);
	}

	@Override
	public boolean authenticateDoctor(Integer doctorId, String password) {
		if (doctorId == null)
			return false;
		if (password == null)
			return false;
		return dao.authenticateDoctorDao(doctorId, password);
	}

	@Override
	public boolean deleteDrById(Integer id) {
		if (id != null && id != 0) {
			dao.deleteDoctorById(id);
			return true;
		}
		return false;
	}
}