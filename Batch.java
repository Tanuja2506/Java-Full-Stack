package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("Insert into student values(?,?,?,?)");
			ps.setInt(1, 21);
			ps.setString(2, "Raju");
			ps.setString(3, "Pceo");
			ps.setInt(4, 22);
			
			//add it to batch
			ps.addBatch();
			
			ps.setInt(1, 22);
			ps.setString(2, "Ram");
			ps.setString(3, "icem");
			ps.setInt(4, 28);
			ps.addBatch();
			
			
			ps.setInt(1, 23);
			ps.setString(2, "Riya");
			ps.setString(3, "iit");
			ps.setInt(4, 26);
			ps.addBatch();
			//execute entiring batch once
			ps.executeBatch();
			
			con.close();
			System.out.println("Data Inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			

	}

}
