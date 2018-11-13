package com.hibernateprojecttesting.service;

import com.hibernateprojecttesting.entity.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public void getAllStudents() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse("1996-11-12");
        Timestamp birthdateTimestamp = new java.sql.Timestamp(parsedDate.getTime());

        Student expectedStudent = new Student("Paweł", "Nowak", birthdateTimestamp, "Wrocław", "Polska", "paweł.nowak@gmail.com", "847 634 234", "mężczyzna");
        expectedStudent.setId((long) 2);
        Student student = studentService.getAllStudents().get(0);

        assertEquals(expectedStudent.getId(), student.getId());
        assertEquals(expectedStudent.getName(), student.getName());
        assertEquals(expectedStudent.getSurname(), student.getSurname());
        assertEquals(expectedStudent.getEmail(), student.getEmail());
        assertEquals(expectedStudent.getPhone(), student.getPhone());
        assertEquals(expectedStudent.getBirthDate(), student.getBirthDate());
        assertEquals(expectedStudent.getAddressCountry(), student.getAddressCountry());
        assertEquals(expectedStudent.getAddressCity(), student.getAddressCity());
        assertEquals(expectedStudent.getGender(), student.getGender());

        assertTrue(studentService.getAllStudents() instanceof List);
        assertTrue(studentService.getAllStudents().get(0) instanceof Student);
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
        student.setName("Jan");
        studentService.updateStudent(student);
        assertEquals("Jan", studentService.getStudentById((long) 1).getName());
        student.setName("Marek");
        studentService.updateStudent(student);
        assertEquals("Marek", studentService.getStudentById((long) 1).getName());
    }

    @Test
    public void getStudentById() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse("1996-11-12");
        Timestamp birthdateTimestamp = new java.sql.Timestamp(parsedDate.getTime());

        Student expectedStudent = new Student("Paweł", "Nowak", birthdateTimestamp, "Wrocław", "Polska", "paweł.nowak@gmail.com", "847 634 234", "mężczyzna");
        expectedStudent.setId((long) 2);
        Student student = studentService.getStudentById((long) 2);

        assertEquals(expectedStudent.getId(), student.getId());
        assertEquals(expectedStudent.getName(), student.getName());
        assertEquals(expectedStudent.getSurname(), student.getSurname());
        assertEquals(expectedStudent.getEmail(), student.getEmail());
        assertEquals(expectedStudent.getPhone(), student.getPhone());
        assertEquals(expectedStudent.getBirthDate(), student.getBirthDate());
        assertEquals(expectedStudent.getAddressCountry(), student.getAddressCountry());
        assertEquals(expectedStudent.getAddressCity(), student.getAddressCity());
        assertEquals(expectedStudent.getGender(), student.getGender());
    }

}