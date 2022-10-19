package com.lavneet.Service;

import com.lavneet.Factory.StudentDaoFactory;
import com.lavneet.POJO.Student;
import com.lavneet.Persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService 
{

	@Override
	public String save(Student student) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();	
		
		return studentDao.save(student);
	}

	@Override
	public Student getById(int id) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();	
		return studentDao.getById(id);	
	}

	@Override
	public String updateById(Student student) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(int id) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(id);
	}
	
}
