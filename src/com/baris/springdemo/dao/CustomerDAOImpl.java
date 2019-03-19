package com.baris.springdemo.dao;

import java.io.Console;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baris.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		 Query<Customer> theQuery =currentSession.createQuery("from Customer order by firstName ",Customer.class);
		
		 List<Customer> customers = theQuery.getResultList();
			
		return customers;
			
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession =sessionFactory.getCurrentSession();
				
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		Session currentSession =sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession =sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		currentSession.delete(theCustomer);
		
	}

	@Override
	public List<Customer> searchCustomer(String searchValue) {
		System.out.println("BURAYA GELDÝ");
		Session currentSession =sessionFactory.getCurrentSession();
		searchValue=searchValue.toLowerCase();

		 Query<Customer> theQuery =currentSession.createQuery("from  Customer  "
		 		+ "cus WHERE  cus.firstName like '%"+searchValue+"%'",Customer.class);
	
		 List<Customer> customers = theQuery.getResultList();
			
		return customers;
		
	}

}
