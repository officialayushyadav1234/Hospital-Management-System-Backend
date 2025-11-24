package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Entity.Contact;
import com.ayush.Hospital_Management_System_Spring_boot.Service.ContactService;

@RestController
@RequestMapping("/contact") // This matches your error log URL
@CrossOrigin(origins = "http://localhost:5173") // Fixes the CORS error
public class ContactController {

	@Autowired
	private ContactService service;

	@PostMapping
	public ResponseEntity<String> submitContactForm(@RequestBody Contact contact) {
		try {
			service.saveContact(contact);
			return ResponseEntity.ok("Message sent successfully!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to send message: " + e.getMessage());
		}
	}
}