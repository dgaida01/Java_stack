package com.gaida.bookclub.controllers;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaida.bookclub.models.Book;
import com.gaida.bookclub.models.User;
import com.gaida.bookclub.services.BookService;
import com.gaida.bookclub.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	//*****************************************************************
	//Route to show all the books on the shelf to a current user
	//*****************************************************************
	@GetMapping("/books")
	public String welcome(Model model,HttpSession session) {	
		if(session.getAttribute("userid")==null) {
			return "redirect:/";
		}
		System.out.println("I GOT TO BOOOKS");
		
		model.addAttribute("currentUser", this.userService.findByID((long)session.getAttribute("userid")));
		List <Book> allBooks = this.bookService.findAllBooks();
		model.addAttribute("allBooks" , allBooks);
		
		return "Books.jsp";
	}
	
	
	//*****************************************************************
	//Routes to add and create a new book on the shelf
	// to show all the books on the shelf to a current user
	//*****************************************************************
	
	@GetMapping("/books/add")
	public String addBooks(HttpSession session, Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/";
		}
		
		model.addAttribute("newBook", new Book());
		
		return "AddBook.jsp";
	}
	
	@PostMapping("/books/create")
	public String creatBook(@Valid @ModelAttribute("newBook") Book newBook,BindingResult result,HttpSession session ) {
		
		boolean bookAddedOK;
		if(session.getAttribute("userid")==null) {
			return "redirect:/";
		}
		else if(result.hasErrors()) {
		
			return "AddBook.jsp";
		}
		else {
		 bookAddedOK	=this.bookService.createBook(newBook, (long) session.getAttribute("userid"),result);
		}
		if(bookAddedOK) {
		return "redirect:/books";
		}
		else {
			return "AddBook.jsp";
		}
	}
	
	//*****************************************************************
	//Route for getting the details of one book
	//*****************************************************************

	@GetMapping("/books/{id}/{userid}/details")
	public String bookDetais(@PathVariable("id") long bookid, @PathVariable("userid") long userid, Model model) {
		
		User currentUser = this.userService.findByID(userid);
		Book selectedBook = this.bookService.findById(bookid);
		
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("selectedBook", selectedBook);
		
		boolean hasRead = false;
		int i = 0; 
		List<User> allOwners = selectedBook.getOwners();
		model.addAttribute("origOwner",(selectedBook.getOwners().get(0)));
		
		while(i<allOwners.size()) {
			User anOwner= allOwners.get(i);
			if(anOwner.getId()==currentUser.getId()) {
				hasRead=true;
			}
			i++;

		}
		
		model.addAttribute("hasRead", hasRead);
		return "BookDetails.jsp";
	}

	//*****************************************************************
	//Route for deleting a book
	//*****************************************************************
	 @RequestMapping("/books/delete/{id}")
	 public String deleteBook(@PathVariable("id") long bookid) {
		 
		 this.bookService.deleteBookByID(bookid);
		 
		 return "redirect:/books";
	 }
	
	 
	 @RequestMapping("/trash/{id}")
	 public String trash(@PathVariable("id") long userid) {
		 
//		 this.userService.deleteAccount(userid);
		List<Object[]> objList=  this.bookService.findAllBooksWithoutOwner();
		Object [] obj = new Object[2];
		
		for(int i=0 ; i<objList.size();i++) {
			obj = objList.get(i);
			System.out.println(obj[0]);
			BigInteger biggie= (BigInteger) obj[0];
			long bookid=  biggie.longValue();
			this.bookService.deleteBookByID(bookid);
			System.out.println(bookid);
			
		}
//		
		
		return "redirect:/books";
		 
		 
	 }
	 

}
