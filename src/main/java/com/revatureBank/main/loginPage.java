package com.revatureBank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.revatureBank.Customer.customerLogin;
import com.revatureBank.Employee.employeeLogin;



public class loginPage {
	public static void main(String[] args) {
		System.out.println("******************Welcome To Revature Bank*************************");
		System.out.println("1. Employee Login");
		System.out.println("2. Customer Login");
		System.out.println("3. Create Account");
		System.out.println("4. Account Status");
		System.out.println("5. Logout");
		System.out.println("Enter your choice:");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			employeeLogin.employee();
			break;
		case 2:
			customerLogin.customer(choice, null);
			break;
		case 3:
			applyForAccount.account();
			break;
		case 4:
			accountStatus.getAllCustomer();
			break;
		case 5:
			System.out.println("Thank you for the visit");
			break;
		default:
			System.out.println("Invalid option choosen!");

		}

	}

}
