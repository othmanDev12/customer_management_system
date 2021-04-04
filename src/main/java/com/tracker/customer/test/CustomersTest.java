package com.tracker.customer.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tracker.customer.dao.CustomerDao;
import com.tracker.customer.dao.CustomerImp;
import com.tracker.customer.entity.Customer;

public class CustomersTest {
	
	private static CustomerDao customerDao;
	private static EntityManagerFactory entityMangerFactory;
	private static EntityManager entityManger;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerImp();
		entityMangerFactory = Persistence.createEntityManagerFactory("customerOperationSystem");
		entityManger = entityMangerFactory.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityMangerFactory.close();
		entityManger.close();
	}

	@Test
	public void test() {
		List<Customer> customers = customerDao.listCustomers();
		
		for(Customer customer: customers) {
			System.out.println("customer data are "
					+ " " + customer.getId() + " " + customer.getFirstName() +
					" " + customer.getLastName() + " " + customer.getEmail());
		}
		
		assertTrue(customers != null && customers.size() > 0);
	}
	
	@Test
	public void testSaveCustomer()  {
		Customer customer = new Customer();
		customer.setFirstName("tonny");
		customer.setLastName("kroos");
		customer.setEmail("tonny8@gmail.com");
		
		Customer newCustomer = customerDao.saveCustomer(customer);
		
		assertTrue(newCustomer != null);
			
	}
	
	@Test
	public void testGetCustomer() {
		Integer customerId = 1;
		Customer customer = customerDao.getCustomer(customerId);
		
		assertTrue(customer != null);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer newCustomer = new Customer();
		newCustomer.setId(5);
		newCustomer.setFirstName("killer");
		newCustomer.setLastName("be");
		newCustomer.setEmail("be.bejo@gmail.com");
		Integer expected = 5;
		Customer updateCustomer = customerDao.updateCustomer(newCustomer);
		
		assertEquals(expected, updateCustomer.getId());
	}
	
	@Test
	public void testDeleteCustomer() {
		Integer customerId = 6;
		
		Customer getCustomer = customerDao.deleteCustomer(customerId);
		
		assertTrue(getCustomer != null);
	}
	
	

}
