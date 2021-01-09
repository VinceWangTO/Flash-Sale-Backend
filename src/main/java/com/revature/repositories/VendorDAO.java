package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Vendor;

public interface VendorDAO extends JpaRepository<Vendor, Integer> {

	public Vendor findByEmail(String email);
}
