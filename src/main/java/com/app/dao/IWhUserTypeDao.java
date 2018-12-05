package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUserType(WhUserType whty);

	public void updateWhUserType(WhUserType whty);

	public void deleteWhUserType(Integer whid);

	public WhUserType getOneWhUserType(Integer whid);

	public List<WhUserType> getAllWhUserType();

	public List<WhUserType> getWhUserTypeByType(String whType);

	public boolean isWhUserTypeExist(String whCode);

	public boolean isVendorWhUserTypeConnecteWithItem(Integer id);

	public boolean isCustomerWhUserTypeConnecteWithItem(Integer id);
}
