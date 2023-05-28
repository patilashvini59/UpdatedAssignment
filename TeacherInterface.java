package com.example.Assignment.teacher.service;

import com.example.Assignment.teacher.model.Teacher;

public interface TeacherInterface {
    public String saveData(Teacher teacher);
    public String login(String name,String email);
}
