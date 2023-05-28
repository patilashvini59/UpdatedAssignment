package com.example.Assignment.student.repo;

import com.example.Assignment.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
