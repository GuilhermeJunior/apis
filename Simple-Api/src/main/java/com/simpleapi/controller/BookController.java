package com.simpleapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapi.entity.Book;
import com.simpleapi.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private final BookRepository repository;
	
	public BookController(BookRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Book findOne(@PathVariable("id") Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException());
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book newBook) {
		return repository.save(newBook);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Book updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
	    return repository.findById(id)
	    	      .map(book -> {
	    	    	  book.setName(updatedBook.getName());
	    	    	  book.setAuthor(updatedBook.getAuthor());
	    	    	  book.setNumberOfPages(updatedBook.getNumberOfPages());
	    	        return repository.save(book);
	    	      })
	    	      .orElseThrow(() -> new IllegalArgumentException());
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
