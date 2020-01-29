package com.ips.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ips.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void addStudent(Student student) {
	
		sessionfactory.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		return sessionfactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	@Override
	public Student getStudent(int studentid) {
		return (Student) sessionfactory.getCurrentSession().get(
				Student.class, studentid);
	}

}
