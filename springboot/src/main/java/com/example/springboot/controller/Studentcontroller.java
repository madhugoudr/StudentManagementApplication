package com.example.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;

@CrossOrigin(allowedHeaders="*")
@RestController
public class Studentcontroller {
	
	
	
	private StudentService studentservice;
	
	public Studentcontroller(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	@RequestMapping(value="api/students",method=RequestMethod.GET)
	@ResponseBody
	@GetMapping
	public List<Student> getAllStudents() {
		return studentservice.getAllStudent();
	}	
	
	@RequestMapping(value="api/student",method=RequestMethod.POST)
	@ResponseBody
	public Student createStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);
	}
	

	@RequestMapping(value="api/findstudent/{sid}",method=RequestMethod.GET)
	@ResponseBody
	public Student getStudentById(@PathVariable int sid) {
		return studentservice.getStudentById(sid);

	}
	
	@RequestMapping(value="api/updatestudent/{sid}", method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student,@PathVariable int sid) {
		return studentservice.updateStudent(student, sid);
		
	}
	
	@RequestMapping(value="api/deletestudent/{sid}", method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int sid) {
		studentservice.deleteStudent(sid);
		
		
	}
	
  

}
