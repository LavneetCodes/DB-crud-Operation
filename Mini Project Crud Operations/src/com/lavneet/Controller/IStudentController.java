package com.lavneet.Controller;

import com.lavneet.POJO.Student;

public interface IStudentController 
{
	public String save(Student student);
	public Student getById(int id);
	public String updateById(Student student);
	public String deleteById(int id);
}
