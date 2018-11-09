package com.hibernateprojecttesting.service;

import com.hibernateprojecttesting.configuration.HibernateConfiguration;
import com.hibernateprojecttesting.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentService {

    private SessionFactory sessionFactory;

    public StudentService() {
        sessionFactory = HibernateConfiguration.getSessionFactory();
    }

    public Student getStudentById(Long id) {
        Session session = sessionFactory.openSession();
        Student student = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            student = (Student) session.createQuery("SELECT s FROM Student s WHERE s.id=:ID").setParameter("ID", id).getSingleResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        List<Student> studentsList = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            studentsList = session.createQuery("SELECT s FROM Student s").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentsList;
    }

    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
