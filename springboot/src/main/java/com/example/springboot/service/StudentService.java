package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	
	Student saveStudent(Student student);
	
	Student getStudentById(int sid);
	
	Student updateStudent(Student student,int sid);
	
	void deleteStudent(int sid);

}
