package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("update student set name=? ,college=? ,age=? where id=?");
			
			ps.setString(1, "Ram");
			ps.setString(2, "iit");
			ps.setInt(3, 28);
			ps.setInt(4, 15);
			ps.addBatch();
			
			ps.setString(1, "Shyam");
			ps.setString(2, "nit");
			ps.setInt(3, 27);
			ps.setInt(4, 10);
			ps.addBatch();
			
			ps.setString(1, "Sam");
			ps.setString(2, "iti");
			ps.setInt(3, 23);
			ps.setInt(4, 18);
			ps.addBatch();
			ps.executeBatch();
			con.close();
			System.out.println("Data Updated");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
