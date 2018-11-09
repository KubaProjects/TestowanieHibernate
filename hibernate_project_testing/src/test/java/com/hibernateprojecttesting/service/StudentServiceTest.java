package com.hibernateprojecttesting.service;

import com.hibernateprojecttesting.entity.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@Transactional
public class StudentServiceTest {

    private static StudentService studentService;
    private static TestingCustomTools testingCustomTools;

    @BeforeClass
    public static void beforeClass() {
        studentService = new StudentService();
        testingCustomTools = new TestingCustomTools();
    }

    @Test
    public void getAllStudents() {
        //testingCustomTools.writeStudentList(studentService.getAllStudents());
    }

    @Test
    public void addStudent() throws ParseException {
        String dateValue = "11-12-1996";
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = df.parse(dateValue);

        int studentsCountBeforeAdd = studentService.getAllStudents().size();

        Student student = new Student("Jan", "Nowak", birthDate, "Warszawa", "Polska", "jan.nowak@gmail.com", "321 123 321", "mężczyzna");
        studentService.addStudent(student);
        assertEquals(studentsCountBeforeAdd + 1, studentService.getAllStudents().size());
    }

    @Test
    public void updateStudent() {
        Student student = studentService.getStudentById((long) 1);
        student.setName("Marek");
        studentService.updateStudent(student);
        assertEquals("Marek", studentService.getStudentById((long) 1).getName());
    }

    @Test
    public void getStudentById() {
    }


}