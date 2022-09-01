package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepo gradeRepo;

    @Override
    public Grade registerGrade(Grade grade) {
        Grade savedGrade = this.gradeRepo.save(grade);
        return savedGrade;
    }
}
