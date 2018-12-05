package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType whty) {
		return dao.saveWhUserType(whty);
	}

	@Transactional
	public void updateWhUserType(WhUserType whty) {
		dao.updateWhUserType(whty);
	}

	@Transactional
	public void deleteWhUserType(Integer whid) {
		dao.deleteWhUserType(whid);
	}

	@Transactional(readOnly = true)
	public WhUserType getOneWhUserType(Integer whid) {
		return dao.getOneWhUserType(whid);
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserType() {
		return dao.getAllWhUserType();
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getWhUserTypeByType(String whType) {
		return dao.getWhUserTypeByType(whType);
	}

	@Transactional(readOnly = true)
	public boolean isWhUserTypeExist(String whCode) {
		return dao.isWhUserTypeExist(whCode);
	}

	@Transactional(readOnly = true)
	public boolean isVendorWhUserTypeConnecteWithItem(Integer id) {
		return dao.isVendorWhUserTypeConnecteWithItem(id);
	}

	@Transactional(readOnly = true)
	public boolean isCustomerWhUserTypeConnecteWithItem(Integer id) {
		return dao.isVendorWhUserTypeConnecteWithItem(id);
	}
}
