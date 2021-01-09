package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Credential;
import com.revature.models.Vendor;
import com.revature.services.VendorService;
import com.revature.utils.PasswordUtils;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	private VendorService vs;

	@Autowired
	public VendorController(VendorService vs) {
		this.vs = vs;
	}

	@GetMapping
	public ResponseEntity<List<Vendor>> findAllVendors() {

		return new ResponseEntity<List<Vendor>>(vs.findAllVendors(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Vendor> findVendorById(@PathVariable int id) {

		Vendor v = vs.findVendorById(id);

		if (v == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(v, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Vendor> saveNewVendor(@RequestBody Vendor vendor) {

		// encrypt password
		String salt = PasswordUtils.getSalt(25);
		String securePassword = PasswordUtils.generateSecurePassword(vendor.getPassword(), salt);
		vendor.setVendorId(0);
		vendor.setPassword(securePassword);
		vendor.setSalt(salt);

		vs.saveVendor(vendor);
		return new ResponseEntity<>(vendor, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<Vendor> login(@RequestBody Credential cred) {

		Vendor v = vs.findVendorByEmail(cred.getEmail());
		if (v == null) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}

		boolean passwordMatch = PasswordUtils.verifyUserPassword(cred.getPassword(), v.getPassword(), v.getSalt());

		if (passwordMatch) {
			return new ResponseEntity<>(v, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
