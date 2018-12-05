package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
	public Integer saveVendor(Vendor vendor);

	public void updateVender(Vendor vendor);

	public void deleteVendor(Integer venId);

	public Vendor getOneVendor(Integer venId);

	public List<Vendor> getAllVendor();
}
