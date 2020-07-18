package com.montran.pojo;

public class Book_library {
	private int bookNumber;
    private String title;
    private double price,cost;
   
private double total(double no) 
 {    
	return cost= price*no;
}

public double purchase (double no) {
	return total(no);
	}
 
public void input (int bookNumber, String title, double price) {
	this.bookNumber = bookNumber;
	this.title = title;
	this.price=price; 
}


}