package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.service.StudentService;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@Autowired
	private StudentService studentservice;
	
	

	@Override
	public void run(String... args) throws Exception {
//		
//		Student student = new Student();
//		student.setsName("Aadhya");
//		student.setsGrade("A+");
//		student.setsAddress("Hyderabad");
//		studentrepository.save(student);

//		Student student1 = new Student();
//		student1.setsName("John");
//		student1.setsGrade("A");
//		student1.setsAddress("Hyderabad");
//		studentrepository.save(student1);
		
//		Student student2= new Student();
//		student2.setsName("Aarush");
//		student2.setsGrade("B");
//		student2.setsAddress("Vizag");
//		studentservice.saveStudent(student2);
//	}

}
	
}
