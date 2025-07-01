package com.jentzen007.Student.Info.Services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jentzen007.Student.Info.Repository.StudentRepository;
import com.jentzen007.Student.Info.model.Student;

@Service
public class StudentServices {
@Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List <Student> allStudent = studentRepository.findAll();
        return allStudent;
    }

    public Student getById(long id) {
        Student idStudent = studentRepository.findById(id).get();
        return idStudent;
    }

    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public Student updateById(long id, Student student) {
        Student existing = studentRepository.findById(id).get();

        if(student.getBDate() != null) {
            int age = Period.between(student.getBDate(), LocalDate.now()).getYears();
            existing.setAge(age);
        }
        existing.setName(student.getName());
        int mark = student.getMarks();
        if(mark < 50) {
            existing.setGrade("F");
        } else if(mark < 70) {
            existing.setGrade("B");
        } else if(mark < 80) {
            existing.setGrade("B+");
        } else if(mark < 90) {
            existing.setGrade("A");
        } else if(mark < 95) {
            existing.setGrade("A+");
        } else {
            existing.setGrade("O");
        }
        existing.setMarks(student.getMarks());
        existing.setBDate(student.getBDate());
        existing.setUsername(student.getUsername());
        existing.setPassword(student.getPassword());

        return studentRepository.save(existing);
    }
    
    public Student createStudent(@RequestBody Student student) { 
        if(student.getBDate() != null) {
            int age = Period.between(student.getBDate(), LocalDate.now()).getYears();
            student.setAge(age);
        }
        int mark = student.getMarks();
        if(mark < 50) {
            student.setGrade("F");
        } else if(mark < 70) {
            student.setGrade("B");
        } else if(mark < 80) {
            student.setGrade("B+");
        } else if(mark < 90) {
            student.setGrade("A");
        } else if(mark < 95) {
            student.setGrade("A+");
        } else {
            student.setGrade("O");
        }
        return studentRepository.save(student);
    }

    public Student findByUsernameAndPassword(String username, String password) {
        return studentRepository.findByUsernameAndPassword(username, password);
    }
}
