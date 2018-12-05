package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;

	@Transactional
	public Integer saveItem(Item item) {
		return dao.saveItem(item);
	}

	@Transactional
	public void updateItem(Item item) {
		dao.updateItem(item);
	}

	@Transactional
	public void deleteItem(Integer iId) {
		dao.deleteItem(iId);
	}

	@Transactional(readOnly = true)
	public Item getOneItem(Integer iId) {
		return dao.getOneItem(iId);
	}

	@Transactional(readOnly = true)
	public List<Item> getAllItem() {
		return dao.getAllItem();
	}

}
