package com.lavneet.Factory;

import com.lavneet.Controller.IStudentController;
import com.lavneet.Controller.StudentControllerImpl;

public class StudentControllerFactory 
{
	private static IStudentController studentController;
	static 
	{
		// interface type ref. assigned to the child class object..
		studentController=new StudentControllerImpl();
		
	}
	public static IStudentController getStudentController()
	{
		return studentController;
	}

}
