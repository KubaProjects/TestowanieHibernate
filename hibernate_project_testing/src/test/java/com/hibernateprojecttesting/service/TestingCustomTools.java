package com.hibernateprojecttesting.service;

import com.hibernateprojecttesting.entity.Student;

import java.util.List;

public class TestingCustomTools {

    public void writeStudentList(List<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.println("Id: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Surname: " + student.getSurname());
            System.out.println("Birth date: " + student.getBirthDate());
            System.out.println("Address city: " + student.getAddressCity());
            System.out.println("Address country: " + student.getAddressCountry());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Gender: " + student.getGender());
            System.out.println("******************************************");
        }
    }
}
