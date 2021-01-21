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
public class BookController 
{
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public ModelAndView   all()
	{
		
		ModelAndView model = new ModelAndView("displayBooks");
		
		List<Book> articleList = bookService.getAll();
		
		model.addObject("articleList", articleList);
		
		return model;
	
	}
	
	@RequestMapping(value="/addNewBook/",method=RequestMethod.GET)
	 public ModelAndView addBook() 
	{	 
	  ModelAndView model = new ModelAndView();
	  Book book = new Book();
	  model.addObject("bookForm", book);
	  model.setViewName("book_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/editBook/{id}", method=RequestMethod.GET)
	 public ModelAndView editBook(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Optional<Book> book = bookService.findBookByID(id);
	  model.addObject("bookForm", book);
	  model.setViewName("book_form");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addBook", method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView add(@Valid @ModelAttribute("bookForm")  Book book,BindingResult result) 
	{
		if (result.hasErrors()) {
			return new ModelAndView("book_form");
		} 
		
		bookService.saveBook(book);
	  return new ModelAndView("redirect:/");
	  
	 }
	 
	 @RequestMapping(value="/deleteBook/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id) 
	 {
		 
		 bookService.deleteBook(id);
	  return new ModelAndView("redirect:/");
	  
	 }
	
	 
}
