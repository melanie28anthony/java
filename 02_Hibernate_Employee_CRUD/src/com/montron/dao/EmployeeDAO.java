package com.montron.dao;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.pojo.Employee;
import com.montran.util.SessionFactoryUtil;

public class EmployeeDAO {
	
	private Session session;
	private Transaction transaction;

	public int addNewEmployee(Employee employee) {
		if (SessionFactoryUtil.getSessionFactory() != null) {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			session.close();
		}
		return 0;
	}

	public boolean updateEmployee(Employee employee) {
		if (getEmployee(employee.getEmployeeId()) != null) {
			if (SessionFactoryUtil.getSessionFactory() != null) {
				session = SessionFactoryUtil.getSessionFactory().openSession();
				Query query = session.createQuery("from Employee");
				List<Employee> employeeList = query.list();
				transaction = session.beginTransaction();
				session.update(employee);
				transaction.commit();
				session.close();
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	public boolean deleteEmployee(int employeeId) {
		Employee employee = getEmployee(employeeId);
		if (employee != null) {
			if (SessionFactoryUtil.getSessionFactory() != null) {
				session = SessionFactoryUtil.getSessionFactory().openSession();
				
				transaction = session.beginTransaction();
				session.delete(employee);
				transaction.commit();
				session.close();
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	public List<Employee> getAllEmployees() {
		if (SessionFactoryUtil.getSessionFactory() != null) {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from employee_hibernate");
			List<Employee> employeeList = query.list();
			session.close();
			return employeeList;
		}
		return null;
	}
	
	

	public Employee getEmployee(int employeeId) {
		if (SessionFactoryUtil.getSessionFactory() != null) {
			session = SessionFactoryUtil.getSessionFactory().openSession();
			Employee employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				session.close();
				return employee;
			}
			session.close();
			return null;
		} else
			return null;
	}
	
	
	
}
