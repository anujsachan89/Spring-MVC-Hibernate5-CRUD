package com.anuj.springhibernate.dao;

import java.util.List;

import com.anuj.springhibernate.entity.Customer;

public interface CustomerDAO {
List<Customer> getCustomers();

void save(Customer theCustomer);

Customer getCustomer(int id);

void deleteCustomer(int id);
List<Customer> searchCustomers(String theSearchName);

}
