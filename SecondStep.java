package com.first;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class SecondStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("first step is done");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
String user="root";
String password="root";

try {
	Connection con=DriverManager.getConnection(url,user,password);
	System.out.println("2 nd step is done");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	

}
