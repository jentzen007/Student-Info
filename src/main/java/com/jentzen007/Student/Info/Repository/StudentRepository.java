package com.jentzen007.Student.Info.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jentzen007.Student.Info.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsernameAndPassword(String username, String password);
}
