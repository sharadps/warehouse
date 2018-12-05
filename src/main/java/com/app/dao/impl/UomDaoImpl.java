package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom uom) {
		return (Integer) ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	@Override
	public void deleteUom(Integer uomId) {
		Uom uom = new Uom();
		uom.setUomId(uomId);
		ht.delete(uom);

	}

	@Override
	public Uom getOneUom(Integer uomId) {
		return ht.get(Uom.class, uomId);
	}

	@Override
	public List<Uom> getAllUom() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public boolean isUomModelExist(String uomModel) {
		@SuppressWarnings("unchecked")
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("uomModel", uomModel)));
		return rowsCount.get(0) != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomConnectedWithItem(Integer id) {
		List<Long> rowsCount = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("uom.uomId", id)));
		return rowsCount.get(0) != 0 ? true : false;
	}

}
