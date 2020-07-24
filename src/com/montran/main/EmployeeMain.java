package com.montran.main;
import java.io.File;

import java.util.Scanner;

import com.montran.util.EmployeeInputStreamUtil;
import com.montran.util.EmployeeOutputStreamUtil;
//import com.montran.util.EmployeeUtil;
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    EmployeeInputStreamUtil employeeinput= new EmployeeInputStreamUtil();
	    EmployeeOutputStreamUtil employeeoutput= new EmployeeOutputStreamUtil();
	    int employeeId;
	    String name;
	    String data;
	    Double salary;
	    File file= null;
	    byte []fileData=null;
	    String path;
	    
	    System.out.println("Enter file path to print metadata");
		path = scanner.next();

		file = new File(path);
	    
	    System.out.println("enter employee id");
	    employeeId= scanner.nextInt();
	
	    System.out.println("enter name");
	    name= scanner.next();
	    
	    System.out.println("enter salary");
	    salary = scanner.nextDouble();
	    
	    data= name + " " +employeeId+" "+salary; 
	    
	    employeeoutput.writeDataIntoFile(file, data.getBytes());
	    
	    fileData= employeeinput.getFileData(file);
	    for(byte b: fileData)
	    {
	    	System.out.print((char) b);
	    }
	    scanner.close();    		
	}
	

}
