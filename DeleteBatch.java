package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBatch {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("delete from student where id=?");
			
			ps.setInt(1,21 );
			
            int rows=ps.executeUpdate();
			
			if (rows > 0) {
			    System.out.println(rows + " record(s) deleted");
			} else {
			    System.out.println("No record found with given id");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
