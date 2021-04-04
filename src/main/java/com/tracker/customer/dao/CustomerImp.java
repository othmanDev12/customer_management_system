                                                                                                                                        package com.tracker.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tracker.customer.entity.Customer;

@Repository
public class CustomerImp implements CustomerDao {
	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public CustomerImp() {
		entityManagerFactory = Persistence.createEntityManagerFactory("customerOperationSystem");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		List<Customer> customers = null;
		try {
			String sql = "customer.listAll";
			Query query = entityManager.createNamedQuery(sql);
			customers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return customer;
		
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		Customer getCustomer = null;
		try {
			getCustomer = entityManager.find(Customer.class, customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getCustomer;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		entityManager.getTransaction().begin();
		Customer customer = null;
		try {
			customer = entityManager.find(Customer.class, customerId);
			entityManager.remove(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return customer;
		
	}
	



}
