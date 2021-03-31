package com.simplebookstore.api.interfaces;

import org.springframework.data.domain.Page;

import com.simplebookstore.api.dto.BookPostDTO;
import com.simplebookstore.api.dto.BookPutDTO;
import com.simplebookstore.api.dto.BookResponseDTO;
import com.simplebookstore.api.entity.BookPage;

public interface BookService {
	
	 BookResponseDTO addBook(BookPostDTO newBook);
	 Page<BookResponseDTO> findAll(BookPage page);
	 BookResponseDTO findBookById(Long id);
	 BookResponseDTO updateBook(BookPutDTO updatedBook, Long id);
	 void deleteBook(Long id);
	
	
}
