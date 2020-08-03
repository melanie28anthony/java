package com.montran.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee_hibernate")
public class Employee {
	@Id
	@Column(name="employee_id")
	private int employeeId;
	private String name;
	private  double salary;
	
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int employeeId, String name, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

   public int getEmployeeId() {
		return employeeId;
	}


  public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}





	public String getName() {
		return name;
	}

  public void setName(String name) {
		this.name = name;
	}





	public double getSalary() {
		return salary;
	}

    public void setSalary(double salary) {
		this.salary = salary;
	}
   @Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}
