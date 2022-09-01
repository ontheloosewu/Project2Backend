package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.Behavior;
import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.repos.GradeRepo;
import dev.thebrogrammers.services.GradeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class GradeServiceTests {

    @InjectMocks
    GradeServiceImpl gradeService;

    @Mock
    GradeRepo gradeRepo;

    @Test
    void delete_grade_by_id_test() {

        Grade grade = new Grade(1, 2, 450000000, "Student has eaten all his vegetables", Behavior.EXCELLENT);
        Mockito.when(gradeRepo.findById(1)).thenReturn(Optional.of(grade));

        Assertions.assertTrue(this.gradeService.deleteGradeById(1));
    }

    @Test
    void delete_fail_grade_id_not_found_test() {
        Mockito.when(gradeRepo.findById(1)).thenReturn(Optional.empty());

        Assertions.assertFalse(this.gradeService.deleteGradeById(1));
    }
}
