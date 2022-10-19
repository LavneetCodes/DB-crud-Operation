package com.lavneet.Factory;

import com.lavneet.Persistence.IStudentDao;
import com.lavneet.Persistence.StudentDaoImpl;

public class StudentDaoFactory 
{
	private static IStudentDao studentDao;
	static 
	{
		studentDao = new StudentDaoImpl();
	}
//	public static IStudentDao getDao()
//	{
//		return ;
//	}
	public static IStudentDao getStudentDao() 
	{
		return studentDao;
	}

}
