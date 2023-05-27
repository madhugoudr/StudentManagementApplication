package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.StudentNotFoundException;
import com.example.springboot.repository.Studentrepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private Studentrepository studentrepository;
	
	public StudentServiceImpl(Studentrepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(int sid) {
		Optional<Student> student = studentrepository.findById(sid);
		if(student.isPresent()) {
			return student.get();
		}
		else {
			throw new StudentNotFoundException("Student not found with" + sid);
		}
		
	}

	@Override
	public Student updateStudent(Student student, int sid) {
		
		Student existingStudent = studentrepository.findById(sid).orElseThrow(
				() -> new StudentNotFoundException("Student not found with specified " + sid));
		
		existingStudent.setsName(student.getsName());
		existingStudent.setsGrade(student.getsGrade());
		existingStudent.setsAddress(student.getsAddress());
		studentrepository.save(existingStudent);

		return existingStudent;
	}

	@Override
	public void deleteStudent(int sid) {
		studentrepository.deleteById(sid);
	}

	
	
}
