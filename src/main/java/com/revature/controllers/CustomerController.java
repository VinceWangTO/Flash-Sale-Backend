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
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.utils.PasswordUtils;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService cs;

	@Autowired
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}

	@GetMapping
	public ResponseEntity<List<Customer>> findAllCustomers() {

		return new ResponseEntity<List<Customer>>(cs.findAllCustomers(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {

		Customer c = cs.findCustomerById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer customer) {

		// encrypt password
		String salt = PasswordUtils.getSalt(25);
		String securePassword = PasswordUtils.generateSecurePassword(customer.getPassword(), salt);
		customer.setCustomerId(0);
		customer.setPassword(securePassword);
		customer.setSalt(salt);
		cs.saveCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<Customer> login(@RequestBody Credential cred) {

		Customer c = cs.findCustomerByEmail(cred.getEmail());
		if (c == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		boolean passwordMatch = PasswordUtils.verifyUserPassword(cred.getPassword(), c.getPassword(), c.getSalt());

		if (passwordMatch) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
