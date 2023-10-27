package com.employee_data_management.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee_data_management.model.Employee;
import com.employee_data_management.util.Hibernate_Util;

public class Employee_Dao {

	Scanner sc = new Scanner(System.in);

	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = Hibernate_Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();

			}

		}
	}

	public void deleteEmployee(int id) {
		Transaction transaction = null;
		try (Session session = Hibernate_Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);

			if (employee != null) {
				session.delete(employee);
				transaction.commit();
				System.out.println("EMPLOYEE ID " + id + " HAS BEEN SUCCESSFULLY DELETED!!");
			} else {
				System.out.println("EMPLOYEE DATA NOT FOUND WITH ID: " + id);
			}
		} catch (Exception e) {
			System.out.println("ERROR OCCURRED WHILE DELETING DATA: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateEmployee() {
	    Transaction transaction = null;
	    try (Session session = Hibernate_Util.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        
	        System.out.println("ENTER THE EMPLOYEE ID TO UPDATE: ");
	        int n = sc.nextInt();

	        Employee employee = session.get(Employee.class, n);

	        if (employee != null) {
	            System.out.println("ENTER NEW EMPLOYEE FIRSTNAME: ");
	            employee.setF_name(sc.next());

	            System.out.println("ENTER NEW EMPLOYEE LASTNAME: ");
	            employee.setL_name(sc.next());

	            System.out.println("ENTER EMPLOYEE NEW EMAIL ID: ");
	            employee.setEmail(sc.next());

	            System.out.println("ENTER EMPLOYEE NEW SALARY: ");
	            employee.setSalary(sc.next());

	            System.out.println("ENTER EMPLOYEE NEW PHONE NO.: ");
	            employee.setPhone(sc.next());

	            System.out.println("ENTER EMPLOYEE NEW DESIGNATION: ");
	            employee.setDesignation(sc.next());

	            // The transaction is committed here, not outside the if statement
	            transaction.commit();
	            System.out.println("EMPLOYEE DATA UPDATED SUCCESSFULLY!!");
	        } else {
	            System.out.println("EMPLOYEE DATA NOT FOUND WITH THIS ID: " + n);
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }
	}


	public void getDataById(int id) {
		Transaction transaction = null;
		try (Session session = Hibernate_Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);

			if (employee != null) {
				System.out.println("\nEmployee Data:");
				System.out.println("ID: " + employee.getId());
				System.out.println("FIRSTNAME: " + employee.getF_name());
				System.out.println("LASTNAME: " + employee.getL_name());
				System.out.println("EMAIL ID: " + employee.getEmail());
				System.out.println("SALARY: " + employee.getSalary());
				System.out.println("PHONE NO.: " + employee.getPhone());
				System.out.println("DESIGNATION: " + employee.getDesignation());
				System.out.println("\nEMPLOYEE DATA FETCHED SUCCESSFULLY!!");
			} else {
				System.out.println("\nEMPLOYEE DATA NOT FOUND WITH ID: " + id);
			}

			transaction.commit();
		} catch (Exception e) {
			System.out.println("\nERROR OCCURRED WHILE FETCHING DATA: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
