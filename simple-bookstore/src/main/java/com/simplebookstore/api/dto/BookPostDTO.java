package com.simplebookstore.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookPostDTO {
	
	private String name;
	private String author;
	private Integer pages;
}
