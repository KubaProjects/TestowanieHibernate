package com.hibernateprojecttesting.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "addressCity")
    private String addressCity;

    @Column(name = "addressCountry")
    private String addressCountry;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;


    public Student() {
    }

    public Student(String name, String surname, Date birthDate, String addressCity, String addressCountry, String email, String phone, String gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public Student(Student student) {
        this.name = student.getName();
        this.surname = student.getSurname();
        this.birthDate = student.getBirthDate();
        this.addressCity = student.getAddressCity();
        this.addressCountry = student.getAddressCountry();
        this.email = student.getEmail();
        this.phone = student.getPhone();
        this.gender = student.getGender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", addressCity='" + addressCity + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}