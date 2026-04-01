package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {

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
//			String query="CREATE TABLE Emp(id INT PRIMARY KEY ,name VARCHAR(20),email VARCHAR(30),salary INT,gender VARCHAR(10))";
//			state.execute(query);

			//Insert records
			String qu="INSERT INTO Emp VALUES"
			        + "(101 ,'Tanuja','aaa@gmail.com',1200,'female'),"
			        + "(102 ,'Tanvi','ab@gmail.com',1800,'female'),"
			        + "(103 ,'Anuja','cc@gmail.com',1600,'female'),"
			        + "(104 ,'Manju','ad@gmail.com',1700,'female'),"
			        + "(105 ,'Tanishk','afg@gmail.com',1300,'male'),"
			        + "(106 ,'Raj','ahi@gmail.com',1000,'male'),"
			        + "(107 ,'Sai','ajhgj@gmail.com',1100,'male')";

			state.execute(qu);
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
