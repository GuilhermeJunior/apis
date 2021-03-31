package com.simplebookstore.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplebookstore.api.dto.BookPostDTO;
import com.simplebookstore.api.dto.BookPutDTO;
import com.simplebookstore.api.dto.BookResponseDTO;
import com.simplebookstore.api.entity.BookPage;
import com.simplebookstore.api.interfaces.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService service;
	
	@PostMapping("/add")
	public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookPostDTO newBook){
		return new ResponseEntity<>(service.addBook(newBook), HttpStatus.CREATED);	
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<Page<BookResponseDTO>> findAll(BookPage page){
		return new ResponseEntity<>(service.findAll(page), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<BookResponseDTO> findById(@PathVariable Long id){
		return new ResponseEntity<>(service.findBookById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<BookResponseDTO> updateBook(@RequestBody BookPutDTO updatedBook, @PathVariable Long id){
		return new ResponseEntity<>(service.updateBook(updatedBook, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
