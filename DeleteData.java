package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			
			
			//delete  data using id
			//PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE id=?");
			
			//delete data using age
			PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE age=?");
			Scanner sc=new Scanner(System.in);
//			System.out.println("Enter id");
//			int id=sc.nextInt();
//			ps.setInt(1, id);
			
			System.out.println("Enter age");
			int age=sc.nextInt();
			ps.setInt(1, age);
			int rows=ps.executeUpdate();
			
			if (rows > 0) {
			    System.out.println(rows + " record(s) deleted");
			} else {
			    System.out.println("No record found with given id");
			}
			
			
			con.close();
			System.out.println("Data Fetch");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
