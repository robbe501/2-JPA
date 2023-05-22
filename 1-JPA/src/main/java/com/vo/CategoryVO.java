package com.vo;

public class CategoryVO {
	private String name;

	public CategoryVO() {
	}

	public CategoryVO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryVO [name=" + name + "]";
	}

}
