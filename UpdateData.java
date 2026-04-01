package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			//based on id
			//PreparedStatement ps=con.prepareStatement("update  student set name= ? where id=?");
			//based on age 
			PreparedStatement ps=con.prepareStatement("update student set name=? ,id=? where age=?");
			
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			System.out.println("Enter Ename:");
			String name=sc.next();
			System.out.println("Enter Age:");
			int age=sc.nextInt();
			

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.execute();
			
			con.close();
			System.out.println("Data Update");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
