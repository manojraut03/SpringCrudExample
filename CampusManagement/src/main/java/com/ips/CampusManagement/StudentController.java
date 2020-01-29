package com.ips.CampusManagement;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ips.model.Student;
import com.ips.service.StudentService;

@Controller
public class StudentController {
	//private static final Logger logger = Logger
		//	.getLogger(StudentController.class);
	public StudentController() {
		System.out.println("StudentController()");
	}

	private StudentService studentService;
	
	@RequestMapping(value = "/")
	public ModelAndView listStudent(ModelAndView model) throws IOException {
		List<Student> listStudent = studentService.getAllStudent();
		model.addObject("listStudent", listStudent);
		model.setViewName("home");
		return model;
		}
	
	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Student student = new Student();
		model.addObject("student", student);
		model.setViewName("StudentForm");
		return model;
	}
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Student student) {
		if (student.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			studentService.addStudent(student);
		} /*else {
			studentService.updateStudent(student);
		}*/
		return new ModelAndView("redirect:/");
	}
}