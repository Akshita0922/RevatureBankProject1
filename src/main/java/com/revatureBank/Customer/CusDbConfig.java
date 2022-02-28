package com.revatureBank.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CusDbConfig {
		public static String url = "jdbc:postgresql://localhost:5432/revaturebank";
		public static String user = "postgres";
		public static String password = "19@ashok#22";
		public static Connection createDBConnection() {
			Connection con=null;
			try {
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection(url, user, password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}

	}
