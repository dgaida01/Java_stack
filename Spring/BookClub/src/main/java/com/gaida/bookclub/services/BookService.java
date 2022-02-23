package com.gaida.bookclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gaida.bookclub.models.Book;
import com.gaida.bookclub.models.User;
import com.gaida.bookclub.repositories.BookRepository;
import com.gaida.bookclub.repositories.UserRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepository userRepo;
	
//*****************************************************************
//Service to handling Adding a new Book to the shelf 
//*****************************************************************
	public boolean createBook(Book newBook,long user_id,BindingResult result ) {

		User currentUser = this.userRepo.findById(user_id).orElse(null);
		Book existingBook = this.bookRepo.findByTitleIgnoreCase(newBook.getTitle()).orElse(null);
		boolean bookAddedOK=false;
		
		if(existingBook==null) {
			ArrayList<User> crr = new ArrayList<User>(); 
			crr.add(currentUser);
			newBook.setOwners(crr);
			newBook.setComments("Owner &nbsp;  " +currentUser.getUserName() +" says "+ newBook.getComments());
//			System.out.println(newBook.getOwners().get(0).getUserName());
			this.bookRepo.save(newBook);
			bookAddedOK=true;
			
		}
		else {
			
			boolean newOwner=true;
			List<User> allOwners = existingBook.getOwners();
			for(int i=0; i <existingBook.getOwners().size();i++) {
				if(allOwners.get(i).getId()==currentUser.getId()) {
					result.rejectValue("title", "alreadyOwner", "You can't add this you are already an owner");
					newOwner=false;
				}
					
			}
			if(newOwner) {
				existingBook.setComments(existingBook.getComments()+"<br> owner:&nbsp; " +currentUser.getUserName() +" adds: &nbsp;"+ newBook.getComments());
				existingBook.getOwners().add(currentUser);
				this.bookRepo.save(existingBook);
				bookAddedOK= true;
			}
		}	
		
		return bookAddedOK;
		
}
//*****************************************************************
//Service for Deleting a book from database/
//*****************************************************************	
	
		public void deleteBookByID(long id) {
			this.bookRepo.deleteById(id);
		}
//*****************************************************************
//Service finding all books for a given owner
//*****************************************************************	
	public List<Object[]> findAllBooksWithoutOwner(){
	 return this.bookRepo.findAllBooksWithoutOwner();

	}
	
	public List <Book> findAllBooks(){
		return (List<Book>) this.bookRepo.findAll();
	}
	
	public Book findById(long id) {
		return this.bookRepo.findById(id).orElse(null);
	}

}
