package com.example.Assignment.teacher.repo;

import com.example.Assignment.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
     Teacher findByUserNameAndEmail(String userName,String email);
}
