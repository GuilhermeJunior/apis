package com.simplebookstore.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookPutDTO {
	
	private String name;
	private String author;
	private Integer pages;
}
