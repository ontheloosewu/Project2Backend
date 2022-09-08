package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);

    boolean deleteStudentById(int id);

    Student getStudentById(int id);

    List<Student> getStudentsByGuardianUsername(String guardianUsername);
}
