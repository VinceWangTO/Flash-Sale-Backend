package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Vendor;
import com.revature.repositories.VendorDAO;

@Service
public class VendorServiceImpl implements VendorService {

	private VendorDAO vd;

	public VendorServiceImpl(VendorDAO vd) {
		this.vd = vd;
	}

	@Override
	public List<Vendor> findAllVendors() {

		return vd.findAll();
	}

	@Override
	public Vendor findVendorById(int id) {

		return vd.getOne(id);
	}

	@Override
	public Vendor findVendorByEmail(String email) {

		return vd.findByEmail(email);
	}

	@Override
	public Vendor saveVendor(Vendor vendor) {

		return vd.saveAndFlush(vendor);
	}

}
