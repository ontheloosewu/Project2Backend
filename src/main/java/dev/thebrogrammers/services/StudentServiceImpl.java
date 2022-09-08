package dev.thebrogrammers.services;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.exceptions.StudentNotFoundException;
import dev.thebrogrammers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    JmsTemplate jmsTemplate;
    
    @Override
    public Student registerStudent(Student student)
    {
        String message = "Student " + student.getFirstName() + " " + student.getLastName() + " has been added";
        jmsTemplate.convertAndSend("message-queue",message);
        return this.studentRepo.save(student);  // no business rules at this time. Assuming front end checks first/last name not null
    }

    @Override
    public boolean deleteStudentById(int id) {
        Optional<Student> student = this.studentRepo.findById(id);
        if(student.isPresent()){
            String message = "Student " + student.get().getFirstName() + " " + student.get().getLastName() + " has been deleted";
            jmsTemplate.convertAndSend("message-queue",message);
            this.studentRepo.delete(student.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = this.studentRepo.findById(id);
        if(student.isPresent()){
            return student.get();
        } else {
            throw new StudentNotFoundException();
        }
    }

    @Override
    public List<Student> getStudentsByGuardianUsername(String guardianUsername) {
        return this.studentRepo.findByguardianUsername(guardianUsername);
    }
}
