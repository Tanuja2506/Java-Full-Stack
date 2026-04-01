package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("Insert into student values(?,?,?,?)");
			
			ps.setInt(1, 21);
			ps.setString(2, "Raau");
			ps.setString(3, "Pceo");
			ps.setInt(4, 23);
			
			ps.setInt(1, 31);
			ps.setString(2, "Avni");
			ps.setString(3, "csmmss");
			ps.setInt(4, 29);
			
			
			PreparedStatement us=con.prepareStatement("update student set name=? ,college=? ,age=? where id=?");
			
			us.setString(1, "Rutu");
			us.setString(2, "iiit");
			us.setInt(3, 27);
			us.setInt(4, 11);
			us.addBatch();
			
			us.setString(1, "Ranu");
			us.setString(2, "iit");
			us.setInt(3, 20);
			us.setInt(4, 10);
			us.addBatch();
			
			PreparedStatement s=con.prepareStatement("delete from student where id=?");
			s.setInt(1,22);
			
           int rows=s.executeUpdate();
			
			if (rows > 0) {
			    System.out.println(rows + " record(s) deleted");
			} else {
			    System.out.println("No record found with given id");
			}
			
			
			ps.executeBatch();
			System.out.println("Data Created");
			
			us.executeBatch();
			System.out.println("Data Updated");
			
			s.executeBatch();
			System.out.println("Data deleted");
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}

}
