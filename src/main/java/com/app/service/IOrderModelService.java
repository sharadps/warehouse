package com.app.service;

import java.util.List;

import com.app.model.OrderModel;

public interface IOrderModelService {
	public Integer saveOrderModel(OrderModel omd);

	public void updateOrderModel(OrderModel omd);

	public void deleteOrderModel(Integer omId);

	public OrderModel getOneOrderModel(Integer omId);

	public List<OrderModel> getAllOrderModel();

	public List<OrderModel> getOrderMethodByMode(String mode);

	public boolean isOrderCodeExist(String omcCode);

	public boolean isOMSaleTypeConnectedWithItem(Integer id);

	public boolean isOMPurchaseTypeConnectedWithItem(Integer id);

}
