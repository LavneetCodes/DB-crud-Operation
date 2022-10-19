package com.lavneet.Main;

import java.util.Scanner;

import com.lavneet.Controller.IStudentController;
import com.lavneet.Factory.StudentControllerFactory;
import com.lavneet.POJO.Student;

public class MainApp {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		String sid=null, sname=null, sage=null, saddress =null;
		IStudentController studentController=null;
		Student student=null;
		//String status = null;
		while(true)
		{
			System.out.println("Welcome to the Student App");
			System.out.println("Press 1. to create a Student Record");
			System.out.println("Press 2. to view a Student Record");
			System.out.println("Press 3. to update a Student Record");
			System.out.println("Press 4. to delete a Student Record");
			System.out.println("Enter Your Option");
			int option = sc.nextInt();
			switch (option)
			{
			case 1:// Collecting the Inputs for StudentDB
				System.out.println("Enter the Student ID: ");
				sid = sc.next();
				System.out.println("Enter the Student name: ");
				sname=sc.next();
				System.out.println("Enter the Student age: ");
				sage = sc.next();
				System.out.println("Enter the Student address: ");
				saddress = sc.next();
				// creating the object of student class and setting the values.. 
				student = new Student ();
				student.setSid(Integer.parseInt(sid));
				student.setSname(sname);
				student.setSage(Integer.parseInt(sage));
				student.setSaddress(saddress);
				studentController = StudentControllerFactory.getStudentController();
				String status1 = studentController.save(student);
				System.out.println("Status: "+status1);
				break;
			case 2: // Collecting the SID from user..
				System.out.println("Enter the Student ID: ");
				sid = sc.next();
				studentController = StudentControllerFactory.getStudentController();
				student = studentController.getById(Integer.parseInt(sid));
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
				System.out.println(" "+student.getSid()+" "+student.getSname()+" "+student.getSage()+" "+student.getSaddress());
				break;
			case 3: // Collecting ID of the student For Updating the Record in the studentDB....
				
				break;
			case 4:
				System.out.println("Enter the Student ID: ");
				sid = sc.next();
				studentController = StudentControllerFactory.getStudentController();
				String status2 = studentController.deleteById(Integer.parseInt(sid));
				System.out.println("Status: "+status2);
				break;
			case 5: System.exit(0);
				break;
			default: System.out.println("Enter the valid option");
			break;
			}
		}
		

	}

}
