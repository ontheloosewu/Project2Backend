package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class StudentRepoTests {

    @Autowired
    StudentRepo studentRepo;

    @Test
    public void delete_student(){
        Student student1 = this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        Student student2 = this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        Student student3 = this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        this.studentRepo.deleteById(student1.getsId());
        List<Student> studentList = this.studentRepo.findAll();
        Assertions.assertEquals(2, studentList.size());
    }

    @Test
    public void get_all_students(){
        this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        this.studentRepo.save(new Student(0, "first", "last", "guardian"));
        List<Student> studentList = this.studentRepo.findAll();
        Assertions.assertTrue(studentList.size() >= 3);
    }

}
