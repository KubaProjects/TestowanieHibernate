package com.hibernateprojecttesting.configuration;

import com.hibernateprojecttesting.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfiguration {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/students");
            prop.setProperty("hibernate.connection.username", "postgres");
            prop.setProperty("hibernate.connection.password", "test");
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");

            Configuration hibernateConfiguration = new Configuration();
            hibernateConfiguration.addProperties(prop);
            hibernateConfiguration.addAnnotatedClass(Student.class);

            sessionFactory = hibernateConfiguration.buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }

    public static void closeSessionFactory() throws HibernateException {
        sessionFactory.close();
    }

}
