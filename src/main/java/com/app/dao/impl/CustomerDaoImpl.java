package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveCustomer(Customer cust) {
		return (Integer) ht.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);
	}

	@Override
	public void deleteCustomer(Integer custId) {
		Customer cust = new Customer();
		cust.setCustId(custId);
		ht.delete(custId);
	}

	@Override
	public Customer getOneCustomer(Integer custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return ht.loadAll(Customer.class);
	}

}
