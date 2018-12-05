package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderModelDao;
import com.app.model.OrderModel;
import com.app.service.IOrderModelService;

@Service
public class OrderModelServiceImpl implements IOrderModelService {

	@Autowired
	private IOrderModelDao dao;

	@Transactional
	public Integer saveOrderModel(OrderModel omd) {
		return dao.saveOrderModel(omd);
	}

	@Transactional
	public void updateOrderModel(OrderModel omd) {
		dao.updateOrderModel(omd);
	}

	@Transactional
	public void deleteOrderModel(Integer omId) {
		dao.deleteOrderModel(omId);
	}

	@Transactional(readOnly = true)
	public OrderModel getOneOrderModel(Integer omId) {
		return dao.getOneOrderModel(omId);
	}

	@Transactional(readOnly = true)
	public List<OrderModel> getAllOrderModel() {
		return dao.getAllOrderModel();
	}

	@Transactional(readOnly = true)
	public List<OrderModel> getOrderMethodByMode(String mode) {
		return dao.getOrderMethodByMode(mode);
	}

	@Override
	public boolean isOrderCodeExist(String omcCode) {
		return dao.isOrderCodeExist(omcCode);
	}

	@Override
	public boolean isOMSaleTypeConnectedWithItem(Integer id) {
		return dao.isOMSaleTypeConnectedWithItem(id);
	}

	@Override
	public boolean isOMPurchaseTypeConnectedWithItem(Integer id) {
		return dao.isOMPurchaseTypeConnectedWithItem(id);
	}

	

}
