package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;
    
    @Override
    public Student registerStudent(Student student)
    {
        return this.studentRepo.save(student);  // no business rules at this time. Assuming front end checks first/last name not null
    }

    @Override
    public boolean deleteStudentById(int id) {
        Optional<Student> student = this.studentRepo.findById(id);
        if(student.isPresent()){
            this.studentRepo.delete(student.get());
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Student getStudentByName(String name) {
        String[] names = name.split(" ");
        if (names.length == 2)
            return this.studentRepo.findByFirstNameAndLastName(names[0], names[1]);
        else
            throw new RuntimeException("Temp exception name isn't in format 'First Last'");
    }
}
