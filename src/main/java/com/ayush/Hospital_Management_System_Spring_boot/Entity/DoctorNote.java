package com.ayush.Hospital_Management_System_Spring_boot.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist; // <--- Import this
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_notes")
public class DoctorNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noteId;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String noteContent;

	@JsonIgnore
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt; // Remove the = LocalDateTime.now() here

	// --- ADD THIS BLOCK ---
	// This runs automatically right before the data is saved to the database.
	@PrePersist
	protected void onCreate() {
		if (this.createdAt == null) {
			this.createdAt = LocalDateTime.now();
		}
	}
}