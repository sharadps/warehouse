package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveItem(Item item) {
		return (Integer) ht.save(item);
	}

	@Override
	public void updateItem(Item item) {
		ht.update(item);
	}

	@Override
	public void deleteItem(Integer iId) {
		Item item = new Item();
		item.setiId(iId);
		ht.delete(item);
	}

	@Override
	public Item getOneItem(Integer iId) {
		return ht.get(Item.class, iId);
	}

	@Override
	public List<Item> getAllItem() {
		return ht.loadAll(Item.class);
	}

}
