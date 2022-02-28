package com.revatureBank.Employee;
import java.util.Scanner;

import com.revatureBank.Customer.CusDbConfig;

import java.sql.*;
public class employeeLogin {
	private static int id;
	public static void employee()                 
	{
	try {
	      
	Connection con = EmpDbConfig.createDBConnection();
	}
	        catch(Exception e)
	        {
	        e.printStackTrace();
	        }
	Scanner sc=new Scanner(System.in);
	System.out.println("************Employee Login********************");
	System.out.println("Enter your Name");
	String ename=sc.nextLine();
	System.out.println("Enter Your Password");
	String epassword=sc.nextLine();
	        if(ename.equals("akshita")&&epassword.equals("akshu@123"))
	        {
	        design();
	        }
	        else {
	        System.out.println("Invalid credential Please try again");
	        }
	       
	}



	public static void design()
	{
	System.out.println("1 . View Customer's Account");
	System.out.println("2. Approving status of pending Account");
	System.out.println("3 . Transaction details of all account");
	System.out.println("Press 1/2/3/4 to Continue");
	Scanner sc=new Scanner(System.in);
	int press=sc.nextInt();
	switch(press) {
	case 1 :
	view_customer_details();
	break;
	case 2:
	approving_status_of_pending_account();
	break;
	case 3:
	transaction_details();
	break;
	default:
	System.out.println("Invalid choice ");
	}}

	public static void view_customer_details()
	{
	try {
		Connection con=CusDbConfig.createDBConnection();
		Statement st=con.createStatement();
	String p="Select * from customer";
	ResultSet rs=st.executeQuery(p);
	System.out.println("Enter customerId");
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	boolean o=false;
	while(rs.next())
	{
	if(id == rs.getInt(1))
	{
	System.out.println("Customer id :"+" "+rs.getInt(1));
	System.out.println("Customer name : "+" "+rs.getString(2));
	System.out.println("Customer email :"+" "+rs.getString(3));
	System.out.println("Customer phone :"+rs.getString(4));
	System.out.println("Customer password :"+rs.getInt(5));
	System.out.println("Customer address :"+" "+rs.getString(6));
	System.out.println("Customer balance :"+rs.getInt(7));
	System.out.println("Customer aadharno :"+rs.getLong(8));
	o=true;
	}

	}
	if(o==false)
	{
	System.out.println("Does Not Exist");
	}
	}
	        catch(Exception e)
	        {
	        e.printStackTrace();
	        }
	}

	public static void approving_status_of_pending_account()
	{
	int i=0;
	try {
		Connection con=CusDbConfig.createDBConnection();
		Statement st=con.createStatement();
	System.out.print("Press YES To Approve Records :");
	Scanner sc=new Scanner(System.in);
	char enter=sc.next().charAt(0);  
	if(enter==121) {
	String p="Select * from customer";
	boolean o=false;
	ResultSet rs=st.executeQuery(p);
	while(rs.next())
	{
	if(rs.getInt(3)>=1000)
	{
	String t="Update customer set status=1 where deposit>=1000";
	PreparedStatement stmt=con.prepareStatement(t);

	i=st.executeUpdate(t);
	o=true;
	}

	}
	if(i>0)
	System.out.println("Record Updated Successfully");
	if(o==false)
	{
	System.out.println("Does Not Exist");
	}

	}}
	catch(Exception e)
	        {
	        e.printStackTrace();
	        }

	}
	public static void transaction_details()
	{
	try {
	    	Connection con=CusDbConfig.createDBConnection();
			Statement st=con.createStatement();
	String p="Select * from transaction";
	ResultSet rs=st.executeQuery(p);
	while(rs.next())
	{
	System.out.println("Sender's Account :"+" "+rs.getInt(1)+"   Receiver Account : "+rs.getInt(2)+"    Amount Transfer:  "+rs.getInt(3));
	}

	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}
}


