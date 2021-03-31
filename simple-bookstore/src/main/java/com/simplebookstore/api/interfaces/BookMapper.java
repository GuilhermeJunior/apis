package com.simplebookstore.api.interfaces;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.simplebookstore.api.dto.BookPostDTO;
import com.simplebookstore.api.dto.BookPutDTO;
import com.simplebookstore.api.dto.BookResponseDTO;
import com.simplebookstore.api.entity.Book;

@Mapper(componentModel = "string")
public interface BookMapper {
	
	@Mapping(target = "pages" , source = "numberOfPages")
	BookResponseDTO toDTO(Book model);
	
	List<BookResponseDTO> listToDTO(List<Book> models);
	
	@Mapping(target = "numberOfPages", source = "pages")
    Book postToModel(BookPostDTO dto);
	
	@Mapping(target = "numberOfPages", source = "pages")
	Book putToModel(BookPutDTO dto);
	
}
