package com.ips.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ips.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public void deleteStudent(Integer sid) {
		Student student=(Student) sessionFactory.getCurrentSession().load(Student.class , sid);
		if(null!=student)
		{
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

	@Override
	public Student getStudent(int sid) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, sid);
	}

	@Override
	public Student updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return student;
	}
}
