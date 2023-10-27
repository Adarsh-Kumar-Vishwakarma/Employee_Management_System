package com.employee_data_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_ID")
    private int Id;

    @Column(name = "Employee_FirstName")
    private String F_name;

    @Column(name = "Employee_LastName")
    private String L_name;

    @Column(name = "Employee_Email")
    private String Email;

    @Column(name = "Employee_Salary")
    private String Salary;

    @Column(name = "Employee_Phone")
    private String Phone;

    @Column(name = "Employee_Designation")
    private String Designation;

	public Employee(String f_name, String l_name, String email, String salary, String phone, String designation) {
		super();
		F_name = f_name;
		L_name = l_name;
		Email = email;
		Salary = salary;
		Phone = phone;
		Designation = designation;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public String getL_name() {
		return L_name;
	}

	public void setL_name(String l_name) {
		L_name = l_name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", F_name=" + F_name + ", L_name=" + L_name + ", Email=" + Email + ", Salary="
				+ Salary + ", Phone=" + Phone + ", Designation=" + Designation + "]";
	}

    
}
