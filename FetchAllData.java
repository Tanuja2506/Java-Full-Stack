package com.second;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class FetchAllData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,password);
		
			Statement state=con.createStatement();
			String query="SELECT * FROM emp";
			state.execute(query);
			
			ResultSet rs=state.getResultSet();
			//shift cursor
			while(rs.next()){//check row is present or not
				//how to display data present in RS obj
				int id=rs.getInt(1);
				String name=rs.getString("name");
				 String email=rs.getString("email");
				 int sal=rs.getInt("salary");
				 String gender=rs.getString("gender");
				 
				System.out.println(id+" "+name+" "+email+ " "+sal+""+gender);
				System.out.println("Data Fetched");
			}
				//Delete data based on gender	
			String q = "DELETE FROM Emp WHERE gender='female'";

			int rows = state.executeUpdate(q);

			System.out.println(rows + " record(s) deleted");
			con.close();
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}
