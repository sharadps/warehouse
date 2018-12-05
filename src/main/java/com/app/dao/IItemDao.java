package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	public Integer saveItem(Item item);

	public void updateItem(Item item);

	public void deleteItem(Integer iId);

	public Item getOneItem(Integer iId);

	public List<Item> getAllItem();
}
