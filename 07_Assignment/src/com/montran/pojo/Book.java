package com.montran.pojo;

public class Book {
      
	private int BookId;
	private String name;
	private double price;
	
	
	public Book(int bookId, String name, double price) {
		super();
		BookId = bookId;
		this.name = name;
		this.price = price;
	}


	public int getBookId() {
		return BookId;
	}


	public void setBookId(int bookId) {
		BookId = bookId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", name=" + name + ", price=" + price + ", getBookId()=" + getBookId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}
	
	
	
	
	
}
