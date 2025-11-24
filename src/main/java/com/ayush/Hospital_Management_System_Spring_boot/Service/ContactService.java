package com.ayush.Hospital_Management_System_Spring_boot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Contact;
import com.ayush.Hospital_Management_System_Spring_boot.Repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;

	public Contact saveContact(Contact contact) {
		return repository.save(contact);
	}
}