package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService 
{
   @Autowired
	private CustomerRepository customerRepository;
   
   public Optional<Customer> getByID(final int id)
   {
	   return customerRepository.findById(id);
   }
   
   public List<Customer> getAll()
   {
	   return customerRepository.findAll();
   }
   
	/*
	 * public Customer updateCustomer(final int id, final Customer customer) {
	 * return customerRepository.save(customer); }
	 */
   
   public Customer saveCustomer(final Customer customer)
   {
	   return customerRepository.save(customer);
   }
   
   public void deleteCustomer(final int id)
   {
	    customerRepository.deleteById(id);
   }
   
   public Optional<Customer> findCustomerByID(final int id)
   {
	   return customerRepository.findById(id);
   }
}
