package com.ips.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ips.controller.StudentController;
import com.ips.model.Student;
import com.ips.service.StudentService;

@Controller
public class StudentController {
	
	private static final Logger logger = Logger
			.getLogger(StudentController.class);
	
	public StudentController()
	{
		System.out.println("StudentController");
	}
	@Autowired
	public StudentService studentService;
	
	@RequestMapping(value="/")
	public ModelAndView listStudent(ModelAndView model) throws IOException
	{	List<Student> listStudent=studentService.getAllStudent();
		model.addObject("listStudent", listStudent);
		model.setViewName("home");
		return model;
		
	}
	@RequestMapping(value="newStudent", method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) throws NotReadablePropertyException {
		Student student= new Student();
		model.addObject("student", student);
		model.setViewName("StudentForm");
		return model;
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public ModelAndView saveStudent (@ModelAttribute Student student)
	{
		if(student.getSid()==0) {
			studentService.addStudent(student);
		}
		else {
			studentService.updateStudent(student);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request)
	{
		int studentId=Integer.parseInt(request.getParameter("sid"));
		studentService.deleteStudent(studentId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		
		int studentId=Integer.parseInt(request.getParameter("sid"));
		Student student= studentService.getStudent(studentId);
		ModelAndView model=new ModelAndView("StudentForm");
		model.addObject("student", student);
		return model;
	}
}
