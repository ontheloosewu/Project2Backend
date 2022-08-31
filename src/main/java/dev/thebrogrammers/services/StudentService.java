package dev.thebrogrammers.services;

public interface StudentService {

    Student registerStudent(Student student);
    boolean deleteStudentById(int id);

}
