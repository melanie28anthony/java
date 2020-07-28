package com.montran.main;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;

import com.montran.util.EmployeeSqlUtil;

public class EmployeeSqlMain {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		List<Employee> employeeList=new ArrayList<Employee>();
		EmployeeSqlUtil employeecollectionutil= new EmployeeSqlUtil();
		Employee employee;
		Employee [] employees=null;
		int employeeId;
		String name;
		double salary;
		int EmployeeDetailchoice;
		boolean result= true;
		int numberofemployDetails;
		String continueChoice;
		do {
			employeeList=employeecollectionutil.getAllEmployees();
			
			for(Employee employeetemp:employeeList){
				if(employeetemp!=null){
					System.out.println(employeetemp.getEmployeeId()+"\t"+employeetemp.getName()+"\t"+employeetemp.getSalary());
					}
				}
			
			System.out.println("Menu");
			System.out.println("1. Add Single Employee	");
			System.out.println("2. Add Multiple Employee");
			System.out.println("3. Update Existing Employee");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");
	        System.out.println("enter your choice");
	        EmployeeDetailchoice=scanner.nextInt();
	        
	        switch(EmployeeDetailchoice) {
	        case 1:
	        	System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Name");
				name = scanner.nextLine();

				System.out.println("Enter Salary");
				salary = scanner.nextDouble();

				employee = new Employee(employeeId, name, salary);

				System.out.println("Add New Employee");
				employeecollectionutil.addNewEmployee(employee);
				break;
	        case 2:
	        	System.out.println("how many books you want to add");
	    		numberofemployDetails=scanner.nextInt();
	    		
	    		
	    			employees=new Employee[numberofemployDetails];
	    			for(int i =0; i< numberofemployDetails;i++)
	    			{
	    				System.out.println("Enter employeeId");
	    				employeeId = scanner.nextInt();
	    				scanner.nextLine();
	    				System.out.println("Enter Name");
	    				name = scanner.nextLine();

	    				System.out.println("Enter Salary");
	    				salary = scanner.nextDouble();

	    				employee = new Employee(employeeId, name, salary);
	    				employeecollectionutil.addNewEmployee(employee);
	    		    }   System.out.println("Printing All Employees");
	    			    employeeList=employeecollectionutil.getAllEmployees();
	    				System.out.println("books are added");
	    			    
	    		        break;
	    		        
	        case 3:
	        	   System.out.println("Enter employeeId");
				   employeeId = scanner.nextInt();
	    		   
	    		    
	    			System.out.println("enter new price");
	    	        salary=scanner.nextDouble();
	    	        System.out.println("enter name");
	    	        name= scanner.next();
	    			
	    			result=employeecollectionutil.updateEmployeeSalary(employeeId, name,salary);
	    			if(result)
	    				System.out.println("employee details updated");
	    			else {
	    				System.out.println("employee details updation failed");
	    			}
	    		break;
	    		
	        case 4:
	        	System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				result=employeecollectionutil.deleteEmployee(employeeId);
	                if (result)
	    			System.out.println("employeed deleted");
	    			else
	    				System.out.println("employee deletion failed1");
	    				
	    		break;
	    		
	        case 5:
	        	System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
	    		employee= employeecollectionutil.getEmployeeByEmployeeId(employeeId);
	    		if(employee!= null)
	    		 {
	    			System.out.println(employee);
	    		} else
	    			System.out.println("No employeeFound !!");
	    		break;
	    	case 6:
	    		System.out.println("Thank you");
	    		System.exit(0);
	    		break;
	    	default:
	    		System.out.println("Invalid Choice");
	    		break;
	    		 }	System.out.println("Do you want to continue yes- no ??");
	    			continueChoice = scanner.next();
		}         while (continueChoice.equals("yes"));
		          System.out.println("Thank you");
	        

	
		        
				

	
}
}
