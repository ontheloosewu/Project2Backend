package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;

public interface StudentService {

    Student registerStudent(Student student);

    boolean deleteStudentById(int id);

    Student getStudentById(int id);
}
