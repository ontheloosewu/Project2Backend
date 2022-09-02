package dev.thebrogrammers.repos;

import dev.thebrogrammers.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {

    List<Grade> findAllGradesBysId(int sId);

    @Transactional
    Long deleteBysId(int studentId);
}
