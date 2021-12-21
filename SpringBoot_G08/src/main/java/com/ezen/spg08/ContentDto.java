package com.ezen.spg08;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContentDto {

	private int id;
	@NotNull(message="Writer is Null")
	@NotEmpty(message="Writer is Empty")
	@Size(min=4, max=20, message="Writer min 4, max 20. ")
	private String writer;
	
	@NotNull(message="content is Null")
	@NotEmpty(message="content is Empty")
	private String content;
}
