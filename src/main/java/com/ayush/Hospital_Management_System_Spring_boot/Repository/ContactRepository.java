package com.ayush.Hospital_Management_System_Spring_boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	// Basic save methods are already included by JpaRepository
}
