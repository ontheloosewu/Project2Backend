package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SpringBootTest
@Transactional
public class StudentServiceTests
{
    @Autowired
    StudentRepo studentRepo;

    @Test
    void add_student_test()
    {
        Student student = new Student(0, "StudentFirst", "StudentLast", "guardianuser");
        Student savedStudent = this.studentRepo.save(student);
        Assertions.assertNotEquals(0, savedStudent.getS_id());
    }
}


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="s_id")
//    private int s_id;
//
//    @Column(name="first_name")
//    private String first_name;
//
//    @Column(name="last_name")
//    private String last_name;
//
//    @Column(name="guardian_username")
//    private String guardian_username;