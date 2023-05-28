package com.example.Assignment.teacher.controller;

import com.example.Assignment.teacher.model.Teacher;
import com.example.Assignment.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<String> saveTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.saveData(teacher);
        return new ResponseEntity<>("Sucessfully", HttpStatus.OK);
    }

    //Teacher Login details
    @GetMapping("/login/{userName}/{email}")
    public ResponseEntity<String> saveTeacher(@PathVariable("userName") String userName, @PathVariable("email") String email) {
        String res = teacherService.login(userName,email);
        return new ResponseEntity<>(res,null);
    }
}
