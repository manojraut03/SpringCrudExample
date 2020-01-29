package com.ips.service;

import java.util.List;

import com.ips.model.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	
	public List<Student>getAllStudent();
	
	public void deleteStudent(Integer sid);

	public Student updateStudent(Student student);
	
	public Student getStudent(int sid);
}
