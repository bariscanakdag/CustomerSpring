package com.baris.springdemo.dao;

import java.util.List;

import com.baris.springdemo.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String searchValue);


	
}
