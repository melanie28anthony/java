package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.montran.pojo.Employee;
import com.montran.util.SessionFactoryUtil;
import com.montron.dao.EmployeeDAO;

public class EmployeeMainV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scanner= new Scanner(System.in);
	EmployeeDAO dao= new EmployeeDAO();
	Employee employee;
	Employee[] employees= null;
	
	//Session session;
	int employee_id;
	String name;
	double salary;
	int EmployeeDetailchoice;
	boolean result;
	int numberofemployDetails;
	String continueChoice;
	 do {
		 
		 List<Employee>employeeList= dao.getAllEmployees();
		 for(Employee emp:employeeList) {
			 if(emp!= null)
				 System.out.println(emp);
			 System.out.println("\n");
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
					employee_id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Name");
					name = scanner.nextLine();

					System.out.println("Enter Salary");
					salary = scanner.nextDouble();

				employee = new Employee(employee_id, name, salary);
				System.out.println("employee added");
				dao.addNewEmployee(employee);
				break;
				
		        case 2:
		        	System.out.println("how many books you want to add");
		    		numberofemployDetails=scanner.nextInt();
		    		   employees=new Employee[numberofemployDetails];
		    			for(int i =0; i< numberofemployDetails;i++)
		    			{
		    				System.out.println("Enter employeeId");
		    				employee_id = scanner.nextInt();
		    				scanner.nextLine();
		    				System.out.println("Enter Name");
		    				name = scanner.nextLine();

		    				System.out.println("Enter Salary");
		    				salary = scanner.nextDouble();

		    				employee = new Employee(employee_id, name, salary);
		    				dao.addNewEmployee(employee);
		    		    }   System.out.println("Printing All Employees");
		    			    employeeList=dao.getAllEmployees();
		    				System.out.println("books are added");
	    			    
		    		        break;
		        case 3:
		        	System.out.println("Enter employeeId");
					   employee_id = scanner.nextInt();
					   System.out.println("Enter Name");
						name = scanner.next();
						System.out.println("Enter Salary");
						salary = scanner.nextDouble();
					employee= dao.getEmployee(employee_id);
					if(employee!= null) {
							
		    			result=dao.updateEmployee(employee);
		    			
		    			if(result)
		    				System.out.println("employee details updated");
		    			else 
		    				System.out.println("employee details updation failed");
		    		}else
		    			System.out.println("no employee found");
					
		    		break;
		    		
		    		case 4:
		    			System.out.println("Enter employeeId");
						employee_id = scanner.nextInt();
						result=dao.deleteEmployee(employee_id);
			                if (result)
			    			System.out.println("employeed deleted");
			    			else
			    				System.out.println("employee deletion failed");
			    				
			    		break;
		    			
		    		
		        case 5:
		        	System.out.println("Enter employee_id");
					employee_id = scanner.nextInt();
		    		employee=dao.getEmployee(employee_id) ;
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
		     }
		        System.out.println("Do you want to continue yes- no ??");
    			continueChoice = scanner.next();
	}         while (continueChoice.equals("yes"));
	          System.out.println("Thank you");
	}

}
