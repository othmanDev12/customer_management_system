package com.tracker.customer.dao;

import java.util.List;

import com.tracker.customer.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> listCustomers();
	
	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomer(Integer customerId);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(Integer customerId);

}
