package dev.thebrogrammers.daycare;


import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.exceptions.StudentNotFoundException;
import dev.thebrogrammers.repos.StudentRepo;
import dev.thebrogrammers.services.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class StudentServiceTests {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepo studentRepo;

    @Mock
    JmsTemplate jmsTemplate;


    @Test
    void delete_student_test() {
        Student student = new Student(1,"test", "student", "guardian email");
        Mockito.when(studentRepo.findById(1)).thenReturn(Optional.of(student));
        Assertions.assertTrue(studentService.deleteStudentById(1));
    }

    @Test
    void delete_fail_student_id_not_found_test()
    {
        Mockito.when(studentRepo.findById(1)).thenReturn(Optional.empty());
        Assertions.assertFalse(studentService.deleteStudentById(1));
    }

    @Test
    void get_nonexistent_student_by_id_test(){
        Mockito.when(studentRepo.findById(1000)).thenReturn(Optional.empty());
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            this.studentService.getStudentById(1000);
        });
    }
}