package com.revatureBank.main;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;

import com.revatureBank.Customer.CusDbConfig;
import com.revatureBank.Customer.Customer;
import com.revatureBank.Employee.Employee;

public class applyForAccount {

	public static void account() {
		System.out.println("******************Create Account*************************");
		System.out.println("1. Employee Account");
		System.out.println("2. Customer Account");
		System.out.println("3. Logout");
		System.out.println("Enter your choice:");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			try {
				insertEmployee();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
		    try {
				insertCustomer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid option choosen!");


		}

	}

	public static void insertCustomer() throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the customer ID:");
		int customerId=Integer.parseInt(s.readLine());
		System.out.println("Enter the customer name");
		String name = s.readLine();
		System.out.println("Enter the Email");
		String email = s.readLine();
		System.out.println("Enter the phone");
		long phone=Long.parseLong(s.readLine());
		System.out.println("Enter the password");
		String password =s.readLine();
		System.out.println("Enter the address");
		String address = s.readLine();
		System.out.println("Enter the balance");
		int balance = Integer.parseInt(s.readLine());
		System.out.println("Enter the AadharNo");
		String aadharNo = s.readLine();
		Customer c=new Customer();
		c.setCustomerId(customerId);
		c.setCustomerName(name);
		c.setCustomerEmail(email);
		c.setPassword(password);
		c.setCustomerPhone(phone);
		c.setCustomerAddress(address);
		c.setCustomerBalance(balance);
		c.setCustomerAadharNo(aadharNo);
		

		// ********JDBC Code Starts here***********

		try {
			Statement stmt = (CusDbConfig.createDBConnection()).createStatement();
			int no = stmt.executeUpdate(
					"insert into customer values('"+c.getCustomerId()+"','" + c.getCustomerName() + "','" + c.getCustomerEmail()+ "','"  + c.getCustomerPhone() + "','"+ c.getPassword() + "','"  + c.getCustomerAddress() + "','" + c.getCustomerBalance()+"','"+ c.getCustomerAadharNo() + "')");
			System.out.println("Insert is done" + no);

		} 
		// ********JDBC Code Ends here***********
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		s.close();
	}

	public static void insertEmployee() throws IOException {
	BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the employee ID:");
		int employeeId=Integer.parseInt(s.readLine());
		System.out.println("Enter the employee name");
		String name = s.readLine();
		System.out.println("Enter the employee Email");
		String email = s.readLine();
		System.out.println("Enter the employee phone");
		long phone=Long.parseLong(s.readLine());
		System.out.println("Enter the password");
		String password =s.readLine();
		System.out.println("Enter the employee address");
		String address = s.readLine();
		System.out.println("Enter the employee AadharNo");
		String aadharNo = s.readLine();
		Employee c=new Employee();
		c.setEmployeeId(employeeId);
		c.setEmployeeName(name);
		c.setEmployeeEmail(email);
		c.setPassword(password);
		c.setEmployeePhone(phone);
		c.setEmployeeAddress(address);
		c.setEmployeeAadharNo(aadharNo);
		c.setEmployeeAddress(address);
//System.out.println(c.getEmployeeName());
		// ********JDBC Code Starts here***********

		try {
			Statement stmt = (CusDbConfig.createDBConnection()).createStatement();
			int no = stmt.executeUpdate(
					"insert into employee values('"	+c.getEmployeeId()+"','"+c.getEmployeeName() + "','" + c.getEmployeeEmail()+ "','"  + c.getPassword() + "','"+ c.getEmployeePhone() + "','"  + c.getEmployeeAddress() +"','"+ c.getEmployeeAadharNo() + "')");
			System.out.println("Insert is done" + no);

		} 
		// ********JDBC Code Ends here***********
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	
	}


	


}
