package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book_library;




public class LibraryMainL2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book_library book = new Book_library ();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter no of copies");
		double no = scanner.nextDouble();
		
		book.input(101,"mela",100);
		if(book.purchase(no)> 0) {
			  System.out.println("Total cost :: " + book.purchase(no));
			    
		}
		else 
			System.out.println("Total cost "+ book.purchase(no));
	 
}
}
