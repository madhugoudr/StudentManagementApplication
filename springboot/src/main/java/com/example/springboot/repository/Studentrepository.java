package com.example.springboot.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Student;

public interface Studentrepository extends JpaRepository<Student, Integer>{
	
//	List<Student> findAll();
//	Student findById(int sid);


}
