package com.atmosphere.gotcha.spring.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ItemDTO {

	@Positive(message="Please provide positive number for id")
	@Digits(fraction=0, integer=Integer.MAX_VALUE, message="Id should not be more than {integer}")
	private Long id;
	
	@NotNull(message="name should not be null")
	@NotBlank(message="name should not be blank")
	@NotEmpty(message="name should not be Empty")
	@Size(min=2, max=300, message="name should have atleast {min} characters and maximum {max} characters")
	private String name;
	
	@NotNull(message="category should not be null")
	@NotBlank(message="category should not be blank")
	@NotEmpty(message="category should not be Empty")
	@Size(min=3, max=300, message="category should have atleast {min} characters and maximum {max} characters")
	private String category;
	
	public ItemDTO() {

	}

	public ItemDTO(Long id) {
		super();
		this.id = id;
	}
	
	public ItemDTO(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}

	public ItemDTO(Long id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}

}