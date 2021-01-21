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
public class CustomerController 
{

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public ModelAndView   all()
	{
		
		ModelAndView model = new ModelAndView("displayCustomers");
		
		List<Customer> articleList = customerService.getAll();
		
		model.addObject("articleList", articleList);
		
		return model;
	
	}
	
	@RequestMapping(value="/addNewCustomer/",method=RequestMethod.GET)
	 public ModelAndView addCustomer() 
	{	 
	  ModelAndView model = new ModelAndView();
	  Customer customer = new Customer();
	  model.addObject("customerForm", customer);
	  model.setViewName("customer_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/editCustomer/{id}", method=RequestMethod.GET)
	 public ModelAndView editCustomer(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Optional<Customer> customer = customerService.findCustomerByID(id);
	  model.addObject("customerForm", customer);
	  model.setViewName("customer_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addCustomer", method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView add(@Valid @ModelAttribute("customerForm")  Customer customer,BindingResult result) 
	{
		if (result.hasErrors()) {
			return new ModelAndView("customer_form");
		} 
		
		customerService.saveCustomer(customer);
	  return new ModelAndView("redirect:/");
	  
	 }
	 
	 @RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id) 
	 {
		 
		 customerService.deleteCustomer(id);
	  return new ModelAndView("redirect:/");
	  
	 }
	
	 
}


