package dev.thebrogrammers.repos;

import dev.thebrogrammers.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
    Student findByFirstNameAndLastName(String first, String last);
}
