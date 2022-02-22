package com.gaida.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaida.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

	Optional<Book> findByTitleIgnoreCase(String title);
	
	@Query(value="select books.id , book_owners.book_id from books left join book_owners on book_id=books.id where book_owners.user_id is null" ,nativeQuery=true)
	List<Object[]> findAllBooksWithoutOwner();
	
	
}
