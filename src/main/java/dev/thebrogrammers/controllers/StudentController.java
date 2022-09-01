package dev.thebrogrammers.controllers;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.services.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController
{
    @Autowired
    StudentService studentService;

    Logger logger = LogManager.getLogger(StudentController.class);

    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<Student> registerStudent(@RequestBody Student body)
    {
        return new ResponseEntity<Student>(this.studentService.registerStudent(body), HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public String deleteStudentById(@PathVariable String id){
        boolean isRemoved = this.studentService.deleteStudentById(Integer.parseInt(id));
        if(isRemoved){
            return "Student has been deleted.";
        } else {
            return "Student was not found.";
        }
    }

}
