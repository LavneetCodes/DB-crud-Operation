package com.lavneet.Persistence;

import com.lavneet.POJO.Student;

public interface IStudentDao {

	public String save(Student student);
	public Student getById(int id);
	public String updateById(Student student);
	public String deleteById(int id);
	

}
