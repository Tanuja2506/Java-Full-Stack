package com.project;

import java.sql.*;
import java.util.Scanner;

public class EmployeeImplementation implements EmployeeInterface {

    Scanner sc = new Scanner(System.in);

    String url = "jdbc:mysql://localhost:3306/jdbc-project?createDatabaseIfNotExist=true";
    String user = "root";
    String password = "root";
    

    //INSERT
    public void saveEmployee() {
    	  
        try (
        		
        		Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO employee (id, name, salary, email, address, companyname) VALUES (?,?,?,?,?,?)")) {

            ps.setInt(1, 22);
            ps.setString(2, "Ram");
            ps.setDouble(3, 30000);
            ps.setString(4, "ram@gmail.com");
            ps.setString(5, "Pune");
            ps.setString(6, "Tcs");

            ps.executeUpdate();
            System.out.println("Data Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateEmployee() {
        try (
        		
        		Connection con = DriverManager.getConnection(url, user, password)) {

            
            System.out.println("\n1.Update Name\n 2.update salary\n3.update email");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            PreparedStatement ps = null;

            switch (choice) {
                case 1:
                    ps = con.prepareStatement("UPDATE employee SET name=? WHERE id=?");
                    System.out.print("Enter new name: ");
                    ps.setString(1, sc.next());
                    ps.setInt(2, id);
                    break;

                case 2:
                    ps = con.prepareStatement("UPDATE employee SET salary=? WHERE id=?");
                    ps.setDouble(1, sc.nextDouble());
                    ps.setInt(2, id);
                    break;

                case 3:
                    ps = con.prepareStatement("UPDATE employee SET email=? WHERE id=?");
                    ps.setString(1, sc.next());
                    ps.setInt(2, id);
                    break;

                default:
                    System.out.println("Invalid choice");
                    return;
            }

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Employee Not Found");

        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    //  DELETE
    public void deleteEmployee() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id=?")) {

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();

            System.out.println(rows > 0 ? "Deleted" : "Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  FETCH ALL
    public void fetchEmployee() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM employee")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | " +
                                   rs.getDouble(3) + "| "+
                                   rs.getString(4) + " | "+
                                   rs.getString(5) + " | "+
                                   rs.getString(6) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FETCH BY ID
    public void fetchEmployeeById() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id=?")) {

            ps.setInt(1, sc.nextInt());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) +" | " + rs.getDouble(3) +" | " + rs.getString(4) +" | " + rs.getString(5) +" | " + rs.getString(6) +" | " );
            } else {
                System.out.println("Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //HIGHEST SALARY
    public void displayHighestSalary() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM employee ORDER BY salary DESC LIMIT 1")) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Highest: " + rs.getString(2) + " | " + rs.getDouble(3)+" | " +  rs.getString(4)+" | " +  rs.getString(5)+ " | " + rs.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LOWEST SALARY
    public void displayLowestSalary() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM employee ORDER BY salary ASC LIMIT 1")) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Lowest: " + rs.getString(2) + " | " + rs.getDouble(3)+" | " + rs.getString(4)+ " | " +rs.getString(5)+" | " + rs.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}