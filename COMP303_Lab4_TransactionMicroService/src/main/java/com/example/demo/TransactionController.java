package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TransactionController 
{
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/")
	public ModelAndView   all()
	{
		
		ModelAndView model = new ModelAndView("displayTransactions");
		
		List<Transaction> articleList = transactionService.getAll();
		
		model.addObject("articleList", articleList);
		
		return model;
	
	}
	
	@RequestMapping(value="/addNewTransaction/",method=RequestMethod.GET)
	 public ModelAndView addTransaction() 
	{	 
	  ModelAndView model = new ModelAndView();
	  Transaction transaction = new Transaction();
	  model.addObject("transactionForm", transaction);
	  model.setViewName("transaction_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/editTransaction/{id}", method=RequestMethod.GET)
	 public ModelAndView editTransaction(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Optional<Transaction> transaction = transactionService.findTransactionByID(id);
	  model.addObject("transactionForm", transaction);
	  model.setViewName("transaction_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addTransaction", method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView add(@Valid @ModelAttribute("transactionForm")  Transaction transaction,BindingResult result) 
	{
		if (result.hasErrors()) {
			return new ModelAndView("transaction_form");
		} 
		
		transactionService.saveTransaction(transaction);
	  return new ModelAndView("redirect:/");
	  
	 }
	 
	 @RequestMapping(value="/deleteTransaction/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id) 
	 {
		 
		 transactionService.deleteTransaction(id);
	  return new ModelAndView("redirect:/");
	  
	 }
	
	 
}
