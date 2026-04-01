package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,password);
		
			Statement state=con.createStatement();
			
			///based on id
			String q="Select * from emp where id=101";
			state.execute(q);
		
			System.out.println("query execute");
			
			//get RS object
			ResultSet rs=state.getResultSet();
			//shift cursor
			if(rs.next()){//check row is present or not
				//how to display data present in RS obj
				int id=rs.getInt(1);
				String name=rs.getString("name");
				 String email=rs.getString("email");
				 int sal=rs.getInt("salary");
				 String gender=rs.getString("gender");
				 
				System.out.println(id+" "+name+" "+email+ " "+sal+""+gender);
				System.out.println("Data Fetched");
			}else {
				System.out.println("id not present");
			}
		
			///based on email
		String s="Select * from emp where email='aaa@gmail.com'";
			state.execute(s);
			System.out.println("query execute");
			
			//get RS object
			ResultSet ps=state.getResultSet();
			//shift cursor
			if(rs.next()){//check row is present or not
				//how to display data present in RS obj
				int id=ps.getInt(1);
				String name=ps.getString("name");
				 String email=ps.getString("email");
				 int sal=ps.getInt("salary");
				 String gender=ps.getString("gender");
				 
				System.out.println(id+" "+name+" "+email+ " "+sal+""+gender);
				System.out.println("Data Fetched");
			}else {
				System.out.println("email not present");
			}
		//based on gender 
			String g="Select * from emp where gender='female'";
			state.execute(g);
			System.out.println("query execute");
			
			//get RS object
			ResultSet ts=state.getResultSet();
			
			if(rs.next()){//check row is present or not
				//how to display data present in RS obj
				int id=ts.getInt(1);
				String name=ts.getString("name");
				 String email=ts.getString("email");
				 int sal=ts.getInt("salary");
				 String gender=rs.getString("gender");
				 
				System.out.println(id+" "+name+" "+email+ " "+sal+""+gender);
				System.out.println("Data Fetched");
			}else {
				System.out.println("gender not present");
			}
//			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
