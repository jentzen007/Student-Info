package com.jentzen007.Student.Info.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jentzen007.Student.Info.Services.StudentServices;
import com.jentzen007.Student.Info.model.Student;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServices service;

    @GetMapping
    public List<Student> findStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateById(@PathVariable @Valid long id, @RequestBody Student student) {
        return service.updateById(id, student);
    }

    @PostMapping
    public Student makeStudents(@Valid @RequestBody Student student) {
        return service.createStudent(student);
    }

    @PostMapping("/login")
    public ResponseEntity <?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Student student = service.findByUsernameAndPassword(username, password);

        if(student != null) return ResponseEntity.ok(student);
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

}
