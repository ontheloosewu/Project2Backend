package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public Student registerStudent(Student student)
    {
        return this.studentRepo.save(student);  // no business rules at this time. Assuming front end checks first/last name not null
    }
}
