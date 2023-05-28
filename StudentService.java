package com.example.Assignment.student.service;

import java.util.List;

import com.example.Assignment.exception.StudentExcp;
import com.example.Assignment.exception.TeacherE;
import com.example.Assignment.student.model.Student;
import com.example.Assignment.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;



	public String saveData(Student student) {
		List<Student> list = studentRepo.findAll();
		if(list.size()==0){
			studentRepo.save(student);
		}else {
			list.stream().forEach(p -> {
				if (p.getRollNo() == student.getRollNo()) {
					throw new StudentExcp("student already exist");
				}
			});
		}
		return "Successfully Save";
	}
	public String updateData(Student student) {
		studentRepo.save(student);
		return "Updated Successfully";
	}

	public Student getStudentById(Integer id) {
		return studentRepo.findById(id).get();
	}

	public Page<Student> getStudentWithPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Student> student = studentRepo.findAll(pageable);
		return student;
	}

}
