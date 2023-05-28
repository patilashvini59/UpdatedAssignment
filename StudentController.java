package com.example.Assignment.student.controller;

import com.example.Assignment.student.model.Student;
import com.example.Assignment.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		studentService.saveData(student);
		return new ResponseEntity<>("Successfully", HttpStatus.OK);
	}

	@PutMapping("/student/update")
	public ResponseEntity<String> updateStudent(@Valid @RequestBody Student student) {
		studentService.updateData(student);
		return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/student/{page}/{size}")
	public ResponseEntity<Page<Student>> getStudentWithPagination(@PathVariable("page") int page,@PathVariable("size") int size) {
		Page<Student> student = studentService.getStudentWithPagination(page, size);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}
