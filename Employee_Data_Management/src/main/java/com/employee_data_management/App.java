package com.employee_data_management;

import java.util.Scanner;

import com.employee_data_management.dao.Employee_Dao;
import com.employee_data_management.model.Employee;

public class App {
	private static final Scanner sc = new Scanner(System.in);
	// private static final Employee_Dao employeeDao = new Employee_Dao();

	public static void main(String[] args) {
		char repeat;
		do {
			displayMenu();
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				deleteEmployee();
				break;
			case 3:
				updateEmployee();
				break;
			case 4:
				getEmployeeById();
				break;
			default:
				System.out.println("INVALID CHOICE. PLEASE SELECT A VALID OPTION.");
			}

			System.out.println("DO YOU WANT TO PERFORM ANOTHER OPERATION? (Y/N): ");
			repeat = sc.next().charAt(0);
		} while (repeat == 'y' || repeat == 'Y');

		System.out.println("THANK YOU FOR USING THE EMPLOYEE MANAGEMENT SYSTEM!");
		sc.close();
	}

	private static void displayMenu() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1) ADD EMPLOYEE DATA");
		System.out.println("2) DELETE EMPLOYEE DATA");
		System.out.println("3) UPDATE EMPLOYEE DATA");
		System.out.println("4) GET EMPLOYEE DATA BY ID");
		System.out.print("ENTER YOUR CHOICE: ");
	}

	public static void addEmployee() {

		System.out.println("HOW MANY EMPLOYEEs DATA YOU WANT TO ADD, like(1,2,3,...)");
		System.out.println();
		int n = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.println("-----------------------------------------------------------------");

			System.out.println("ENTER EMPLOYEE FIRSTNAME: ");
			String f_name = sc.next();

			System.out.println("ENTER EMPLOYEE LASTNAME: ");
			String l_name = sc.next();

			System.out.println("ENTER EMPLOYEE EMAIL ID: ");
			String email = sc.next();

			System.out.println("ENTER EMPLOYEE SALARY: ");
			String salary = sc.next();

			System.out.println("ENTER EMPLOYEE PHONE NO.: ");
			String phone = sc.next();

			System.out.println("ENTER EMPLOYEE Designation: ");
			String designation = sc.next();

			Employee_Dao employee_dao = new Employee_Dao();

			Employee employee = new Employee(f_name, l_name, email, salary, phone, designation);
			employee_dao.saveEmployee(employee);

			System.out.println("-----------------------------------------------------------------");

		}

		System.out.println("EMPLOYEE DATA ADDED SUCCESFULLY!!!!");
	}

	public static void deleteEmployee() {
		Employee_Dao employee_dao = new Employee_Dao();
		System.out.println("ENTER EMPLOYEE ID YOU WANT TO DELETE: ");
		int n = sc.nextInt();

		employee_dao.deleteEmployee(n);

	}

	public static void updateEmployee() {
		Employee_Dao employee_dao = new Employee_Dao();
		employee_dao.updateEmployee();
	}

	public static void getEmployeeById() {
		Employee_Dao employee_dao = new Employee_Dao();
		System.out.println("ENTER EMPLOYEE ID YOU WANT SEE: ");
		int n = sc.nextInt();

		employee_dao.getDataById(n);

	}
}
