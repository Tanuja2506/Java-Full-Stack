package com.first;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ThirdStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";

		try {
			//step1 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2
			Connection con=DriverManager.getConnection(url,user,password);
			//step 3
			Statement state=con.createStatement();
			System.out.println("Third step complete"+state);
			//write query
			//has to be written in String Format
			//table create Query
//			String query="CREATE TABLE student(id INT PRIMARY KEY ,name VARCHAR(20),college VARCHAR(30),age INT )";
//			state.execute(query);
			//update name based on id
			String query="Insert Into student Values(101 ,'Tanuja','Diems',12)";
			state.execute(query);
			//step 5
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
