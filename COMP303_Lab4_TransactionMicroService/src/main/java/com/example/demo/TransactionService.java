package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService 
{
	@Autowired
	private TransactionRepository transactionRepository;
   
   public Optional<Transaction> getByID(final int id)
   {
	   return transactionRepository.findById(id);
   }
   
   public List<Transaction> getAll()
   {
	   return transactionRepository.findAll();
   }
   
	/*
	 * public Customer updateCustomer(final int id, final Customer customer) {
	 * return customerRepository.save(customer); }
	 */
   
   public Transaction saveTransaction(final Transaction transaction)
   {
	   return transactionRepository.save(transaction);
   }
   
   public void deleteTransaction(final int id)
   {
	   transactionRepository.deleteById(id);
   }
   
   public Optional<Transaction> findTransactionByID(final int id)
   {
	   return transactionRepository.findById(id);
   }
}
