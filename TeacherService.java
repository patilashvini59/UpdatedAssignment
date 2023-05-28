package com.example.Assignment.teacher.service;

import com.example.Assignment.exception.TeacherE;
import com.example.Assignment.teacher.model.Teacher;
import com.example.Assignment.teacher.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeacherService implements TeacherInterface{
    @Autowired
    private TeacherRepo teacherRepo;

    public TeacherService() {
    }

    @Override
    public String saveData(Teacher teacher) {
        String encodedPassword = PasswordEncoderCl.encodePassword(teacher.getPassword());
        teacher.setPassword(encodedPassword);
        List<Teacher> list = teacherRepo.findAll();
        if(list.size()==0){
            teacherRepo.save(teacher);
        }else {
            list.stream().forEach(p -> {
                if (p.getEmail().contains(teacher.getEmail())) {
                    throw new TeacherE("Teacher is already exist");
                } else {
                    teacher.setPassword(encodedPassword);
                    teacherRepo.save(teacher);
                }
            });
        }
        return "Save Data Successfully";
    }

    @Override
    public String login(String name, String email) {
        String response="Invalid Credentials";
        Teacher data = teacherRepo.findByUserNameAndEmail(name, email);
        if(data==null) {
            response = "Invalid Credentials";
        }else {
            response = "Login Successfully";
        }
        return response;
    }
}
