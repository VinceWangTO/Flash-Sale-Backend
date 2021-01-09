package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Customer;
import com.revature.repositories.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO cd;

	public CustomerServiceImpl(CustomerDAO cd) {
		this.cd = cd;
	}

	@Override
	public List<Customer> findAllCustomers() {

		return cd.findAll();
	}

	@Override
	public Customer findCustomerById(int id) {

		return cd.getOne(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {

		return cd.saveAndFlush(customer);
	}

	@Override
	public Customer findCustomerByEmail(String email) {

		return cd.findByEmail(email);
	}

}
