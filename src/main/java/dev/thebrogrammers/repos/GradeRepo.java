package dev.thebrogrammers.repos;

import dev.thebrogrammers.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {
}
