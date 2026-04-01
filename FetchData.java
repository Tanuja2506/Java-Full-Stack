package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			//3.based on id
			//PreparedStatement ps=con.prepareStatement("Select * from student where id=?");
			
			//4.based on name
			PreparedStatement ps=con.prepareStatement("Select * from student where name=?");
			
			Scanner sc=new Scanner(System.in);
//			System.out.println("Enter id");
//			int id=sc.nextInt();
//			
//			ps.setInt(1, id);
			
			System.out.println("Enter name:");
			String name=sc.next();
			
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int Id=rs.getInt("id");
				String Name=rs.getString("name");
				 String college=rs.getString("college");
				 int age=rs.getInt("age");
				 
				System.out.println(Id+" "+Name+" "+college+ " "+age);
				
			}else {
				System.out.println("id not present");
			}
			
			
			
			
			con.close();
			System.out.println("Data Fetch");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
