package com.revature.services;

import java.util.List;

import com.revature.models.Vendor;

public interface VendorService {

	public List<Vendor> findAllVendors();

	public Vendor findVendorById(int id);

	public Vendor findVendorByEmail(String email);

	public Vendor saveVendor(Vendor vendor);

}
