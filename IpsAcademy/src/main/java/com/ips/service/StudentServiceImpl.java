package com.ips.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.dao.StudentDao;
import com.ips.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer sid) {
		studentDao.deleteStudent(sid);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int sid) {
		return studentDao.getStudent(sid);
	}

}
