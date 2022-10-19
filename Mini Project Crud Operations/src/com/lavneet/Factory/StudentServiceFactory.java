package com.lavneet.Factory;

import com.lavneet.Service.IStudentService;
import com.lavneet.Service.StudentServiceImpl;

public class StudentServiceFactory 
{
	private static IStudentService studentService;
	static 
	{
		// interface type reference assigned to the child class object..
		studentService=new StudentServiceImpl();
		
	}
	
	public static IStudentService getStudentService() 
	{
		return studentService;
	}
}
