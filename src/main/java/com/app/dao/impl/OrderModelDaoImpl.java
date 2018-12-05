package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderModelDao;
import com.app.model.Item;
import com.app.model.OrderModel;

@Repository
public class OrderModelDaoImpl implements IOrderModelDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderModel(OrderModel omd) {
		return (Integer) ht.save(omd);
	}

	@Override
	public void updateOrderModel(OrderModel omd) {
		ht.update(omd);
	}

	@Override
	public void deleteOrderModel(Integer omId) {
		OrderModel om = new OrderModel();
		om.setOmId(omId);
		ht.delete(om);
	}

	@Override
	public OrderModel getOneOrderModel(Integer omId) {
		return ht.get(OrderModel.class, omId);
	}

	@Override
	public List<OrderModel> getAllOrderModel() {
		return ht.loadAll(OrderModel.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> getOrderMethodByMode(String omModel) {
		// String hql = " from " + OrderModel.class.getName() + " where omModel=?";
		List<OrderModel> data = (List<OrderModel>) ht
				.findByCriteria(DetachedCriteria.forClass(OrderModel.class).add(Restrictions.eq("omModel", omModel)));
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderCodeExist(String omCode) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(OrderModel.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("omCode", omCode)));
		return rowsCount.get(0) != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isOMSaleTypeConnectedWithItem(Integer id) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("omSaleType.omId", id)));
		return rowsCount.get(0) != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isOMPurchaseTypeConnectedWithItem(Integer id) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("omPurchaseType.omId", id)));
		return rowsCount.get(0) != 0 ? true : false;
	}

}
