package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Behavior;
import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.GradeRepo;
import dev.thebrogrammers.services.GradeService;
import dev.thebrogrammers.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GradeServiceTests {

    @Autowired
    StudentService studentService;
    @Autowired
    GradeRepo gradeRepo;
    @Autowired
    GradeService gradeService;

    @Test
    void delete_grade_by_id(){
        Student student = new Student(0,"First","Last","test_guardian");
        Student savedStudent = this.studentService.registerStudent(student);
        Grade grade = new Grade(0, savedStudent.getsId(), 450000000,"Student has eaten all his vegetables", Behavior.EXCELLENT);
        Grade grade2 = new Grade(0, savedStudent.getsId(), 450000000,"Student2 has eaten all his vegetables", Behavior.EXCELLENT);
        Grade grade3 = new Grade(0, savedStudent.getsId(), 450000000,"Student3 has eaten all his vegetables", Behavior.EXCELLENT);
        Grade savedGrade = this.gradeRepo.save(grade);
        Grade savedGrade2 = this.gradeRepo.save(grade2);
        Grade savedGrade3 = this.gradeRepo.save(grade3);
        this.gradeService.deleteGradeById(savedGrade3.getgId());
        Assertions.assertEquals(2, this.gradeRepo.findAll().size());
    }
}
