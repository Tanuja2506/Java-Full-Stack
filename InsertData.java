package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			
			/*
			 * step -3
			 * call preapareStatement()--present in Connection
			 * non static method
			 * throw sql exception
			 * accept one string argument :query
			 * return PrapareStetement obj
			 * ?-delimeter/place holder--columns*/
			
			PreparedStatement ps=con.prepareStatement("Insert into student Values(?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			//ask data to from user and storing them in one variable
			System.out.println("Enter id");
			int id =sc.nextInt();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter college");
			String college=sc.next();
			System.out.println("Enter age");
			int age=sc.nextInt();
			
			//set the data to delimeter ---setX(delimeterPosition,value)
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, college);
			ps.setInt(4, age);
			//execute--ps
			ps.execute();
			
			con.close();
			System.out.println("Data Inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
