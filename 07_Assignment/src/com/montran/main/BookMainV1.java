package com.montran.main;

import com.montran.pojo.Book;

import com.montran.util.BookUtil;



import java.util.Scanner;


public class BookMainV1 {
	public static void main(String[] args) {

	//BookUtil.bookutil = new BookUtil(2);
		BookUtil bookUtil = new BookUtil(10);
		Scanner scanner= new Scanner(System.in);
		Book books[]=null; 
		Book book;
		int Bookchoice;
		int bookId;
		String name;
		double price;
		boolean result;
		int numberofbook;
		String continueChoice;
		
		
		do {
			books=bookUtil.getAllBook();
			for(Book booktemp:books){
				if(booktemp!=null){
					System.out.println(booktemp.getBookId()+"\t"+booktemp.getName()+"\t"+booktemp.getPrice());
					}
				}
			System.out.println("Menu");
			System.out.println("1. Add Single Book	");
			System.out.println("2. Add Multiple Books");
			System.out.println("3. Update Existing Book");
			System.out.println("4. Delete Existing Book");
			System.out.println("5. Print Single Book Details");
			System.out.println("6. Exit");
	System.out.println("enter your choice");
	Bookchoice=scanner.nextInt();
	
	//switch case
	
	switch(Bookchoice){
	case 1:
		System.out.println("enter book id");
	    bookId= scanner.nextInt();
	    System.out.println("enter name");
	    name=scanner.next();
	    System.out.println("enter price");
	    price=scanner.nextDouble();
	    
	    book= new Book(bookId,name,price);
	    
	    result=bookUtil.addNewBook(book);
	    if(result)
	    	System.out.println("book added sucesssfully");
	    else
	    	System.out.println("book addition failed");
	    
	case 2:
		System.out.println("how many books you want to add");
		numberofbook=scanner.nextInt();
		if(numberofbook<(bookUtil.getMaxIndex()-bookUtil.getNextIndex()))
		{
			books=new Book[numberofbook];
			for(int i =0; i< numberofbook;i++)
			{
				System.out.println("enter book id");
			    bookId= scanner.nextInt();
			    System.out.println("enter name");
			    name=scanner.next();
			    System.out.println("enter price");
			    price=scanner.nextDouble();
			    
			    book= new Book(bookId,name,price);
			    books[i]=book;
			    }
			bookUtil.addAllBook(books);
			System.out.println("books are added");
			}else
				System.out.println("no space");
		break;
	case 3:
		System.out.println(" enter bookid no");
		bookId= scanner.nextInt();
		book= bookUtil.getbookbybookid(bookId);
		if(book!= null)
		{
			System.out.println("enter new name");
	    name=scanner.next();
	    System.out.println("enter new price");
	    price=scanner.nextDouble();
			
			result=bookUtil.updateNewBook(bookId,name,price);
			if(result)
				System.out.println("book details updated");
			else
				System.out.println("book details updation failed");
		}else
			System.out.println("no book found");
		
	case 4:
		System.out.println(" enter bookid no");
		bookId= scanner.nextInt();
		book= bookUtil.getbookbybookid(bookId);
		if(book!= null)
		{
			result=bookUtil.deletebook(bookId);
			if (result)
				System.out.println("book deleted");
			else
				System.out.println("book deletion failed");
				}
		else
			System.out.println("no book found");
		break;
	case 5:
		System.out.println("Enter BookId");
		bookId = scanner.nextInt();
		book = bookUtil.getbookbybookid(bookId);
		if (book != null) {
			System.out.println(book);
		} else
			System.out.println("No Book Found !!");
		break;
	case 6:
		System.out.println("Thank you");
		System.exit(0);
		break;
	default:
		System.out.println("Invalid Choice");
		break;
		
		
	    
	    
		
	}
	System.out.println("Do you want to continue yes- no ??");
	continueChoice = scanner.next();
}         while (continueChoice.equals("yes"));
          System.out.println("Thank you");
	}
	
	
	}

