package com.montran.util;

import com.montran.pojo.Book;



public class BookUtil {
 
	private Book[] books;
	private int nextIndex = 0;
	private int maxIndex;
	public  BookUtil (int booksLength)
	{
		books= new Book[booksLength];
		maxIndex= booksLength;
	}
	
	
	
	
	
	public int getNextIndex() {
		return nextIndex;
	}





	public int getMaxIndex() {
		return maxIndex;
	}





	public boolean addNewBook(Book book)
	{
		if(nextIndex >=0 && nextIndex < maxIndex)
		{
			//the value to be added in the util sent to the main
			books[nextIndex]= book;
			nextIndex++;
			
			return true;
		}
		return false;
		
		
}
    public boolean addAllBook(Book[] book){
    	for (Book book2 : books) {
			addNewBook(book2);
		}
	      return true;
	}
   public boolean updateNewBook(int bookId,String newname ,double newprice)
   {
	   for(Book book:books){
		   if(book.getBookId()==bookId) {
			   book.setName(newname);
			   book.setPrice(newprice);
			   return true;
		   }
	   }
		   return false;
   }
	
   public boolean deletebook(int bookId)
   {
	   for(int i= 0; i < books.length;i++)
	   {
	   if (books[i].getBookId()==bookId){
		   books[i]= null;
		  }
	   }
   return false;
   
   }
   
    public Book getbookbybookid(int bookId)
    {
    	for(Book book:books)
    	{
    		if(book!=null)
    		{
    			if(book.getBookId()==bookId)
    				return book;
    		}
    	}
    	return null;
    }
    	
    	public Book[] getAllBooks() 
    	{
    	return books;
    	}
 }
    

		
	
