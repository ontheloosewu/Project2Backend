package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class StudentServiceTests
{
    @Autowired
    StudentService studentService;

    @Test
    void add_student_test()
    {
        Student student = new Student(0, "StudentFirst", "StudentLast", "guardianuser");
        Student savedStudent =  studentService.registerStudent(student);
        Assertions.assertNotEquals(0, savedStudent.getsId());
    }

    @Test
    void get_student_by_name_test()
    {
        Student student = new Student(0, "Alex", "Macklin-Rivera", "guardianuser");
        Student saved = this.studentService.registerStudent(student);

        Student retrievedStudent = this.studentService.getStudentByName("Alex Macklin-Rivera");
        Assertions.assertEquals(saved.getsId(), retrievedStudent.getsId());
    }
}