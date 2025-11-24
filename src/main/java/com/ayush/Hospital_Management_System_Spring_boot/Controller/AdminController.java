package com.ayush.Hospital_Management_System_Spring_boot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.Hospital_Management_System_Spring_boot.Service.AdminService;

@RestController
@RequestMapping(value = "/api/authenticateAdmin")
@CrossOrigin(value = "http://localhost:5173")
public class AdminController {

	@Autowired
	private AdminService service;

	// UPDATED: Changed to use @RequestParam so emails with ".com" work correctly
	// URL will look like:
	// /api/authenticateAdmin/login?identifier=abc@gmail.com&password=123
	@PostMapping(value = "/login")
	public boolean authenticateAdminController(@RequestParam String identifier, @RequestParam String password) {

		return service.authenticateAdmin(identifier, password);
	}
}