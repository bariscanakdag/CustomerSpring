package com.baris.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baris.springdemo.dao.CustomerDAO;
import com.baris.springdemo.entity.Customer;
import com.baris.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customers=customerService.getCustomers();
		
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer=new Customer();
		
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println("Customer ID :" + theCustomer.getId());
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model theModel) {
		
		Customer customer=customerService.getCustomer(theId);
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int theId,Model theModel) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchValue")String searchValue,Model theModel) {
	
		if(searchValue.isEmpty())
			return "redirect:/customer/list";
		
		System.out.println("ARANACAK OLAN KELÝME : " + searchValue );
		
		List<Customer> customers=customerService.searchCustomer(searchValue);
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
	
}
