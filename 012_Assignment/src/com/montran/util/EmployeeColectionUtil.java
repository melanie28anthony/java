package com.montran.util;

import java.util.ArrayList;
import java.util.List;
import com.montran.pojo.Employee;

public class EmployeeColectionUtil {
	
	private List<Employee> employeeList= new ArrayList<Employee>();
	private Employee[] employees;
	private int nextIndex =0;
	private int maxIndex;
	
	public EmployeeColectionUtil(int size) {
		// TODO Auto-generated constructor stub
		 employees= new Employee[size];
		 }
	 public int getNextIndex() {
			return nextIndex;
		}
     public int getMaxIndex() {
			return maxIndex;
		}
     
     public boolean addNewEmployee(Employee employee)
 	{
 		employeeList.add(employee);
 		return false;
 	}
     public List<Employee> getAllEmployees(){
   	  return employeeList;
 	}
     public boolean addAllEmployees(Employee[] employee) {
    	 for(Employee employee1:employeeList) {
    		 addNewEmployee(employee1);
    	 }
    	 return true;
    	 }
     public boolean updateEmployeeSalary(int employeeId ,double newSalary) {
    	 for(Employee employee:employeeList)
    	 {
    		 if(employee.getEmployeeId()==employeeId) {
    			 
    			 employee.setSalary(newSalary);
    			 return true;
    		}
    	 }return false;
    	 }
    	
      public boolean deleteEmployee(int employeeId) {
    	  for(Employee employee:employeeList)
    	  {
    		  if(employee.getEmployeeId()==employeeId)
    		  {
    			  employeeList.remove(employee);
    			  return true;
    		  }
    	  }
    	  return false;
       }
     
      public Employee getEmployeeByEmployeeId(int employeeId) {
    	  for(Employee employee:employeeList)
      	{
      		if(employee!=null)
      		{
      			if(employee.getEmployeeId()==employeeId)
      				return employee;
      		} } 
    	  return null;
      }
      }
      
      
      
      
      
      
     
    	 
    	
    	
     
     
     
     
     
     


