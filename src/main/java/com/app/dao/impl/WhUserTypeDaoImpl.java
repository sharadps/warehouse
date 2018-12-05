package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.Item;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType whty) {
		return (Integer) ht.save(whty);
	}

	@Override
	public void updateWhUserType(WhUserType whty) {
		ht.update(whty);
	}

	@Override
	public void deleteWhUserType(Integer whid) {
		WhUserType whty = new WhUserType();
		whty.setWhId(whid);
		ht.delete(whty);
	}

	@Override
	public WhUserType getOneWhUserType(Integer whid) {
		return ht.get(WhUserType.class, whid);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {
		return ht.loadAll(WhUserType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WhUserType> getWhUserTypeByType(String whType) {
		/*
		 * String hql = " from " + WhUserType.class.getName() + " where whType=? ";
		 * List<WhUserType> list = (List<WhUserType>) ht.find(hql, whType);
		 */
		List<WhUserType> data = (List<WhUserType>) ht.findByCriteria(
				DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eqOrIsNull("whType", whType)));
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isWhUserTypeExist(String whCode) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("whCode", whCode)));
		return rowsCount.get(0) != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isVendorWhUserTypeConnecteWithItem(Integer id) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("venUsers.whId", id)));
		return rowsCount.get(0) != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isCustomerWhUserTypeConnecteWithItem(Integer id) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("custUsers.whId", id)));
		return rowsCount.get(0) != 0 ? true : false;
	}
}
