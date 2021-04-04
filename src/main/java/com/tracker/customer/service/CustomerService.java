package com.tracker.customer.service;

import java.util.List;

import com.tracker.customer.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomer(Integer customerId);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(Integer customerId);

}
