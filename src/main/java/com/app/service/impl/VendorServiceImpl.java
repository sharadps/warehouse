package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
	@Autowired
	private IVendorDao dao;

	@Transactional
	public Integer saveVendor(Vendor vendor) {
		return dao.saveVendor(vendor);
	}

	@Transactional
	public void updateVender(Vendor vendor) {
		dao.updateVender(vendor);
	}

	@Transactional
	public void deleteVendor(Integer venId) {
		dao.deleteVendor(venId);
	}

	@Transactional(readOnly = true)
	public Vendor getOneVendor(Integer venId) {
		return dao.getOneVendor(venId);
	}

	@Transactional(readOnly = true)
	public List<Vendor> getAllVendor() {
		return dao.getAllVendor();
	}

}
