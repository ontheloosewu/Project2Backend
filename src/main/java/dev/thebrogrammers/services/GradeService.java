package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.entities.Student;

public interface GradeService {
    Grade registerGrade(Grade grade);

    Grade getGradesByStudentId(int sId);

}
