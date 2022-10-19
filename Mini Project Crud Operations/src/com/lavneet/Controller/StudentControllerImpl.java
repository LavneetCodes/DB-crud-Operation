package com.lavneet.Controller;

import com.lavneet.Factory.StudentServiceFactory;
import com.lavneet.POJO.Student;
import com.lavneet.Service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public String save(Student student)
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		return studentService.save(student);		
	}

	@Override
	public Student getById(int id)
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();	
		return studentService.getById(id);
	}

	@Override
	public String updateById(Student student) 
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(int id) 
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		return studentService.deleteById(id);
	}

	

}
