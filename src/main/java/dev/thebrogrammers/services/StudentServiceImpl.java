package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;

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
}
