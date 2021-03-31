package com.simplebookstore.api.service;

import java.util.List;

import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.simplebookstore.api.dto.BookPostDTO;
import com.simplebookstore.api.dto.BookPutDTO;
import com.simplebookstore.api.dto.BookResponseDTO;
import com.simplebookstore.api.entity.Book;
import com.simplebookstore.api.entity.BookPage;
import com.simplebookstore.api.exceptions.BookNotFound;
import com.simplebookstore.api.interfaces.BookMapper;
import com.simplebookstore.api.interfaces.BookMapperImpl;
import com.simplebookstore.api.interfaces.BookService;
import com.simplebookstore.api.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Repository
@RequiredArgsConstructor
@Import(BookMapperImpl.class)
@Slf4j
public class BookServiceImpl implements BookService {
	
	private final BookRepository repository;
	private final BookMapper mapper;

	@Override
	public BookResponseDTO addBook(BookPostDTO newBook) {
		 Book book = mapper.postToModel(newBook);
		 repository.save(book);
		 return mapper.toDTO(book);
	}

	@Override
	public Page<BookResponseDTO> findAll(BookPage page) {
		Sort sort = Sort.by(page.getSortDirection(), page.getSortedBy());
		Pageable pageable = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort); 
		List<BookResponseDTO> lista = mapper.listToDTO(repository.findAll(pageable).getContent()); 
		return new PageImpl<>(lista, pageable, lista.size());
	}

	@Override
	public BookResponseDTO findBookById(Long id) {
		Book book =  repository.findById(id)
				.orElseThrow(() -> new BookNotFound("Not Found Book with id: " + id));
		return mapper.toDTO(book);
	}

	@Override
	public BookResponseDTO updateBook(BookPutDTO updatedBook, Long id) {
		
		return repository.findById(id)
				.map(book -> {
					book = mapper.putToModel(updatedBook);
					book.setId(id);
					repository.save(book);
					log.info("The Updated Id is: " + book.getId());
					return mapper.toDTO(book);
				})
				.orElseThrow(() -> new BookNotFound("Not Found Book with id: " + id));
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}





}
