package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer) ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
	}

	@Override
	public void deleteShipmentType(Integer stId) {
		ShipmentType st = new ShipmentType();
		st.setShipId(stId);
		ht.delete(st);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer stId) {
		return ht.get(ShipmentType.class, stId);
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		return ht.loadAll(ShipmentType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentType> getAllShipmentTypeByCode(String shipCode) {
		//String hql = " from " + ShipmentType.class.getName() + " where shipEnabled=?";
		List<ShipmentType> data=(List<ShipmentType>) ht.findByCriteria(DetachedCriteria.forClass(ShipmentType.class).add(Restrictions.eq("shipEnabled", shipCode)));
		return data ;
	}
	

}
