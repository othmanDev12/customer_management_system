package com.tracker.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.customer.dao.CustomerDao;
import com.tracker.customer.entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.listCustomers();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		return customerDao.deleteCustomer(customerId);
	}


}
