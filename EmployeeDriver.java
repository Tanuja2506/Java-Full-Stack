package com.project;

import java.util.Scanner;

public class EmployeeDriver {

	public static void main(String[] args) {

      Scanner sc =new Scanner(System.in);
     EmployeeInterface emp=new EmployeeImplementation(); 
      while(true) {
    	  System.out.println("Welcome to employee Database Project");
    	  System.out.println("1.Save\n 2.Update\n 3. Delete\n 4.FetchAll\n 5.FetchID\n 6.Exit \n 7.DisplayHighestMaximumSalary \n 8.DisplayLowestSalary");
    	  System.out.println("Enter Choice");
    	  int choice=sc.nextInt();
    	  
    	  switch(choice) {
    	  case 1://insert opteration
    		  emp.saveEmployee();
    		  break;
    	  case 2: 
    		  emp.updateEmployee();
    		  break;
    	  case 3:
    		  emp.deleteEmployee();
    		  break;
    		  
    	  case 4:
    		  emp.fetchEmployee(); 
    		  break;
    	  case 5:
    		  emp.fetchEmployeeById();
    		  break;
    	 case 6: System.exit(0);
    	 case 7:
    	    	emp.displayHighestSalary(); 
    	    	break;
    	 case 8: 
    	    	emp.displayLowestSalary(); 
    	    	break;
    	 default: System.out.println("Invalid choice");
    		  
    	  }
    	  
      }

	}

}
