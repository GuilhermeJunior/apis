package com.simplebookstore.api.entity;

import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class BookPage {
	
	private Integer pageNumber = 0;
	private Integer pageSize = 10;
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	private String sortedBy = "name";
}
