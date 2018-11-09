CREATE DATABASE students;

\c students;

DROP TABLE IF EXISTS students;

CREATE TABLE students(
	ID SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	birthDate DATE NOT NULL,
	addressCity VARCHAR(50) NOT NULL,
	addressCountry VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	phone VARCHAR(30) NOT NULL,
	gender VARCHAR(10) NOT NULL
);

INSERT INTO students (name, surname, birthDate, addressCity, addressCountry, email, phone, gender)
	VALUES ('Adam', 'Kowalski', '1997-10-10', 'Warszawa', 'Polska', 'adam.kowalski1@gmail.com', '123 456 789', 'mężczyzna');
	
	