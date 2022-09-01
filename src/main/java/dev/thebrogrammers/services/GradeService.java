package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;

import java.util.List;

public interface GradeService {
    Grade registerGrade(Grade grade);

    List<Grade> getGradesByStudentId(int sId);

    boolean deleteGradeById(int gradeId);
}
