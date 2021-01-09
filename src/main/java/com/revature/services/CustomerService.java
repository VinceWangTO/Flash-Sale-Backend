package com.revature.services;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public Customer findCustomerById(int id);

	public Customer findCustomerByEmail(String email);

	public Customer saveCustomer(Customer customer);

}
