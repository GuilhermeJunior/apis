package com.simplebookstore.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResponseDTO {
	
	private Long id;
	private String name;
	private String author;
	private Integer pages;
}
