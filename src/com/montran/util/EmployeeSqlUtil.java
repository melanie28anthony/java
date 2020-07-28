package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeSqlUtil {
	private List<Employee> employeeList= new ArrayList<Employee>();
	private Employee[] employees;
	private Employee employee;
	private int nextIndex =0;
	private int maxIndex;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "montran";
	String password = "montran";
	String sql = "";
	ResultSet resultSet;
	PreparedStatement addpreparedStatement;
	PreparedStatement getallpreparedStatement;
	PreparedStatement deletepreparedStatement;
	PreparedStatement updatepreparedStatement;
	boolean result= true;
	
	
	public EmployeeSqlUtil() {
		// TODO Auto-generated constructor stub
		 
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "montran", "montran");
		addpreparedStatement = connection.prepareStatement("insert into employee_master values(?,?,?)");
		 getallpreparedStatement= connection.prepareStatement("select * from employee_master");
		 updatepreparedStatement=connection.prepareStatement("update employee_master set name=? , salary=? where employee_id=?");
		 deletepreparedStatement = connection.prepareStatement("delete employee_master where employee_id=?");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	 public boolean addNewEmployee(Employee employee) throws SQLException
 	{
    	 addpreparedStatement.setInt(1, employee.getEmployeeId());
    	 addpreparedStatement.setString(2, employee.getName());
    	 addpreparedStatement.setDouble(3, employee.getSalary());
    	 addpreparedStatement.executeUpdate();
     	 System.out.println("Recored inserted successfully !!");
     	 return false;
 	}
     public List<Employee> getAllEmployees() throws SQLException{
         
         resultSet=  getallpreparedStatement.executeQuery();
         while (resultSet.next()) {
				System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
				System.out.println("Name :: " + resultSet.getString("name"));
				System.out.println("Salary :: " + resultSet.getDouble("salary"));
				System.out.println("----------------------------------------");
			}
   	  return employeeList;
 	}
     
     public boolean addAllEmployees(Employee[] employee) throws SQLException {
    	 for(Employee employee1:employeeList) {
    		 addNewEmployee(employee1);
    	 }
    	 return true;
    	 }
    public boolean updateEmployeeSalary(int EmployeeId,String Name ,double Salary) throws SQLException {
    	
    	   			updatepreparedStatement.setString(1, employee.getName());
			updatepreparedStatement.setDouble(2, employee.getSalary());
				updatepreparedStatement.setInt(3, employee.getEmployeeId());
    			result= updatepreparedStatement.execute();
    			if( result) 
    				return true;
    return false;	 }
    	 
  public boolean deleteEmployee(int employeeId) throws SQLException {
    	 deletepreparedStatement.setInt(1, employee.getEmployeeId());
          boolean result= deletepreparedStatement.execute();
          if (result) 
          return true; 
  return false;}
      
    	  
    	  
     
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
