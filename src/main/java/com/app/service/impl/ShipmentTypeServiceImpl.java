package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		return dao.saveShipmentType(st);
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		dao.updateShipmentType(st);
	}

	@Transactional
	public void deleteShipmentType(Integer stId) {
		dao.deleteShipmentType(stId);
	}

	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(Integer stId) {
		return dao.getOneShipmentType(stId);
	}

	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
		return dao.getAllShipmentType();
	}

	@Override
	public List<ShipmentType> getAllShipmentTypeByCode(String shipCode) {
		return dao.getAllShipmentTypeByCode(shipCode);
	}

}
