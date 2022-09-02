package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public boolean deleteGradeById(int gradeId) {
        Optional<Grade> grade = this.gradeRepo.findById(gradeId);
        if(grade.isPresent()){
            this.gradeRepo.deleteById(grade.get().getgId());
            return true;
        } else {
            return false;
        }
    }
}
