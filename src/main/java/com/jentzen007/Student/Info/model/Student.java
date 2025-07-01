package com.jentzen007.Student.Info.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;



@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Require a name")
    private String name;

    @Min(value = 0, message = "Marks must be more than 0")
    @Max(value = 100, message = "Marks must be lesser than 100")
    private int marks;

    private String grade;

    @JsonProperty("birth_date")
    private LocalDate bDate;

    private int age;

    private String username;
    private String password;

    public Student() {}

    public Student(Long id, String name, int marks, String grade, String username, String password, LocalDate bDate) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
        this.username = username;
        this.bDate = bDate;
        this.password = password;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public String getGrade() {
        return grade;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public LocalDate getBDate() {
        return bDate;
    }
    public int getAge() {
        return age;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    } 
    public void setBDate(LocalDate bDate) {
        this.bDate = bDate;
    }
    public void setAge(int age) {
        this.age = age;
    }
}