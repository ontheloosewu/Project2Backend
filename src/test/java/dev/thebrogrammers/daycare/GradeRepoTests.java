package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Behavior;
import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.GradeRepo;
import dev.thebrogrammers.repos.StudentRepo;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GradeRepoTests {

    @Autowired
    GradeRepo gradeRepo;
    @Autowired
    StudentRepo studentRepo;

    @Test
    public void create_grade(){
        Student student = new Student(0,"First","Last","test_guardian");
        Student savedStudent = this.studentRepo.save(student);
        Grade grade = new Grade(0, savedStudent.getsId(), 450000000,"Student has eaten all his vegetables", Behavior.EXCELLENT);
        Grade savedGrade = this.gradeRepo.save(grade);
        System.out.println(savedGrade);
        Assertions.assertNotEquals(0,savedGrade.getgId());
    }

    @Test
    public void get_grades_by_student_id() {
        Student student = new Student(0, "Alex", "Macklin-Rivera", "guardianuser");
        Student savedStudent = this.studentRepo.save(student);

        Grade grade = new Grade(0, savedStudent.getsId(), 450000000, "Student has eaten all his vegetables", Behavior.SATISFACTORY);
        Grade savedGrade = this.gradeRepo.save(grade);


        Assertions.assertEquals(savedStudent.getsId(), savedGrade.getsId());
        System.out.println(savedStudent);
        System.out.println(savedGrade);
    }

    @Test
    public void delete_grades_by_student_id(){
        Student student = new Student(0, "Alex", "Macklin-Rivera", "guardianuser");
        Student savedStudent = this.studentRepo.save(student);
        Grade grade = new Grade(0, savedStudent.getsId(), 450000000, "Student has eaten all his vegetables", Behavior.SATISFACTORY);
        Grade grade2 = new Grade(0, savedStudent.getsId(), 450000000, "Student has eaten all his vegetables", Behavior.SATISFACTORY);
        Grade grade3 = new Grade(0, savedStudent.getsId(), 450000000, "Student has eaten all his vegetables", Behavior.SATISFACTORY);
        this.gradeRepo.save(grade);
        this.gradeRepo.save(grade2);
        this.gradeRepo.save(grade3);
        Assertions.assertEquals(3l, this.gradeRepo.deleteBysId(savedStudent.getsId()));
    }
}
