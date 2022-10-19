package com.lavneet.Service;

import com.lavneet.POJO.Student;

public interface IStudentService 
{
	public String save(Student student);
	public Student getById(int id);
	public String updateById(Student student);
	public String deleteById(int id);
}
