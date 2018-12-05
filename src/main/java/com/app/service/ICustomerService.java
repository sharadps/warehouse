package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public Integer saveCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public void deleteCustomer(Integer custId);

	public Customer getOneCustomer(Integer custId);

	public List<Customer> getAllCustomer();
}
