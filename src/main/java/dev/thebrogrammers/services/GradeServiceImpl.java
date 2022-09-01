package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.exceptions.GradeNotFoundException;
import dev.thebrogrammers.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepo gradeRepo;

    @Override
    public Grade registerGrade(Grade grade) {
        Grade savedGrade = this.gradeRepo.save(grade);
        return savedGrade;
    }

    @Override
    public List<Grade> getGradesByStudentId(int sId) {
        return this.gradeRepo.findAllGradesBysId(sId);
    }
}
