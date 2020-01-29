package com.ips.dao;

import java.util.List;

import com.ips.model.Student;

public interface StudentDao {
	
	public void addStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public void deleteStudent(Integer sid);
	
	public Student updateStudent(Student student);
	
	public Student getStudent(int sid);

}
