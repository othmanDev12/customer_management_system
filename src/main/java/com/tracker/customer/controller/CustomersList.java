package com.tracker.customer.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.customer.entity.Customer;
import com.tracker.customer.service.CustomerService;

@Controller
@RequestMapping(path = "/customers")
public class CustomersList {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/list" , method = RequestMethod.GET)
	public String listOfCustomers(Model model) {
		// get the list of customers from the customerImp;
		List<Customer> customers = customerService.getCustomers();
		
		/*
		 * for(Customer customer: customers) { if(customer != null) {
		 * System.out.println("the customer data: " + customer.getFirstName()); } }
		 */
		
		// add list of customers to the empty model
		model.addAttribute("customers" , customers);
		return "list-customers";
	}
	
	@RequestMapping(path = "/add-customer-showform" , method = RequestMethod.GET)
	public String showForms(Model model)  {
		Customer customer = new Customer();
		model.addAttribute("customer" , customer);
		
		return "show-customer-form";
	}
	
	
	@RequestMapping(path ="/processCustomerForm" , method = RequestMethod.POST) 
	public String showForm(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())  {
			return "show-customer-form";
		}
		
		if(theCustomer == null) {
			customerService.saveCustomer(theCustomer);
			return "redirect:/customers/list";
		}
		else {
			customerService.updateCustomer(theCustomer);
			return "redirect:/customers/list";
		}
	}
	
	@RequestMapping(path = "/showUpdateForm" , method = RequestMethod.GET)
	public String updateShowForm(@RequestParam("itemId") int theId , Model model) {
		Customer customer = customerService.getCustomer(theId);
		model.addAttribute("customer" , customer);
		return "show-customer-form";
	}
	
	@RequestMapping(path = "/delete" , method = RequestMethod.GET)
	public String getDeleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customers/list";
	}
}
