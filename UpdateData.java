package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,password);
		
			Statement state=con.createStatement();
			//update name based on id
			String q="Update emp set name='Anju'where id=102";
			state.execute(q);
			//update 
			String p="Update emp set name='Rani' and email='ghff@gmail.com' and salary=2000 where id=103";
			state.execute(p);
			//update sal based on email
			String s="Update emp set sal=2300 where id='tanu@gmail.com'";
			state.execute(s);
			
			con.close();
			System.out.println("Table Created..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
