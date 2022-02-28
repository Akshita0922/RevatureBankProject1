package com.revatureBank.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import com.revatureBank.Customer.CusDbConfig;


public class customerLogin{
	public static void customer(int cId,String cPswd){
		try {
			System.out.println("************Customer Login********************");
			Connection con=CusDbConfig.createDBConnection();
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer where customer_id='"+cId+"' and customer_password='"+cPswd+"';");
  	   if (rs.next()) {
  		 System.out.println("Customer id :"+" "+rs.getInt(cId));
  		System.out.println("Customer name : "+" "+rs.getString(cPswd));
	    customerdesign(rs.getInt(cId),rs.getString(cPswd));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


		
		//fetch query for customer_id and password and store in hashmap.
		//match customerid with fetched query customer id
		//if matched then asked for password else user doesnt exist
		
		
		//match the password with password coressponding to the entered customer id
		//if password matched then provide funtionalities else worn password entered
		
		//store customer id in a variable and passed as argument on every function call.
		
		
		
		public static void customerdesign(int cId,String cPswd) {
		System.out.println("******************Welcome To Customer Login*************************");
		System.out.println("1. View Account details");
		System.out.println("2. Deposit");
		System.out.println("3. Withdrawl");
		System.out.println("4. Transfer");
		System.out.println("5. Logout");
		System.out.println("Enter your choice:");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			view_customer_details(101);
			break;	
		case 2:
			//deposite(101);
			break;
//		case 3:
//		    try {
//				customer_transaction(101);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    break;
////		case 4:
//			customerLogin.updateCustomer();;
//			break;
			
		default:
			System.out.println("Invalid option choosen!");


		}

	}

		public static void view_customer_details(int customer_id)
		{
		try {
		 Connection conn=null;
		 String url = "jdbc:postgresql://localhost:5432/revaturebank";
		 String user = "postgres";
		 String password = "19@ashok#22";
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url,user,password);
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from customer where customer_id="+customer_id);
		while(rs.next())
		{
		System.out.println("Customer id :"+" "+rs.getInt(1));
		System.out.println("Customer name : "+" "+rs.getString(2));
		System.out.println("Customer email :"+" "+rs.getString(3));
		System.out.println("Customer phone :"+rs.getString(4));
		System.out.println("Customer password :"+rs.getInt(5));
		System.out.println("Customer address :"+" "+rs.getString(6));
		System.out.println("Customer balance :"+rs.getInt(7));
		System.out.println("Customer aadharno :"+rs.getLong(8));
		}
		}
		        catch(Exception e)
		        {
		        e.printStackTrace();
		        }
		}
		
		

	public static void deposite(int customer_id) {
		Scanner s = new Scanner(System.in);
		int amt=s.nextInt();
		try {
			Statement stmt = (CusDbConfig.createDBConnection()).createStatement();
		     ResultSet rs = stmt.executeQuery ("update customer set customer_balance=customer_balance + amt where customer_id="+customer_id);
		     rs.next();
			
//			int no = stmt.executeUpdate("update customer set name='" + nname +"',password='"+ npassword+ "',phone='" + nphone + "',address='"+ naddress+"',balance='"+nbalance+"',aadharNo='"+naadharno + "' where id=" + customerId + "");
//			if (no != 0) {
//				System.out.println("customer details updated");
//			} else {
//				System.out.println("customer details not updated");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
//
//	}

	public static void customer_transaction(int customer_id) throws SQLException {
		 Connection conn=null;
		 String url = "jdbc:postgresql://localhost:5432/revaturebank";
		 String user = "postgres";
		 String password = "19@ashok#22";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url,user,password);
		Scanner s = new Scanner (System.in);
        System.out.println ("Enter the Destination account number :");  
        int daccno = s.nextInt ();
       System.out.println ("Enter the amount to transfer :");
       int amnt = s.nextInt ();
       conn.setAutoCommit(false);
       Statement st=conn.createStatement();
       ResultSet rs = st.executeQuery ("select customer from account_balance where account_number="+customer_id);
       rs.next ();
       int abal = rs.getInt (1);
       System.out.print (abal);

       if (abal>amnt)

       {

            int up = st.executeUpdate ("update account_balance set avail_balance =avail_balance-"+amnt+ "where account_number=" +customer_id);
            int up1 = st.executeUpdate ("update account_balance set avail_balance = avail_balance-"+amnt+ "where account_number= "+daccno);
            System.out.print (up+" "+up1);
            if (up==1 && up1==1)
            {
                 conn.commit ();
                 System.out.println ("*******: “+amnt+” balance is successfully Transferred:*******");
            }
            else
             {
                 conn.rollback ();
                 System.out.println ("rollback");
            }
       }
       else
         {
               System.out.println ("You does not have sufficient balance !!! please deposit in your account.");

         }
 }
}



