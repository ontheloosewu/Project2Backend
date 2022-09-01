package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.entities.Student;

import java.util.List;

public interface GradeService {
    Grade registerGrade(Grade grade);

    List<Grade> getGradesByStudentId(int sId);

}
