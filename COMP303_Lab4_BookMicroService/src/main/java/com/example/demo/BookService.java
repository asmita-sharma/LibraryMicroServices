package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
	@Autowired
	private BookRepository bookRepository;
   
   public Optional<Book> getByID(final int id)
   {
	   return bookRepository.findById(id);
   }
   
   public List<Book> getAll()
   {
	   return bookRepository.findAll();
   }
   
	/*
	 * public Customer updateCustomer(final int id, final Customer customer) {
	 * return customerRepository.save(customer); }
	 */
   
   public Book saveBook(final Book book)
   {
	   return bookRepository.save(book);
   }
   
   public void deleteBook(final int id)
   {
	   bookRepository.deleteById(id);
   }
   
   public Optional<Book> findBookByID(final int id)
   {
	   return bookRepository.findById(id);
   }
}
