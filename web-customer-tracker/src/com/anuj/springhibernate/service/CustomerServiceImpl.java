package com.anuj.springhibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.springhibernate.dao.CustomerDAO;
import com.anuj.springhibernate.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
		
	}


	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}



}
