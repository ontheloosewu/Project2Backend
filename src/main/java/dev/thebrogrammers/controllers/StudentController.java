package dev.thebrogrammers.controllers;

import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<Student> registerStudent(@RequestBody Student body) {
        return new ResponseEntity<Student>(this.studentService.registerStudent(body), HttpStatus.CREATED);
    }

    @GetMapping("/students/{name}")
    @ResponseBody
    public Student getStudent(@PathVariable String name) {
        return this.studentService.getStudentByName(name);
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable String id) { return this.studentService.getStudentById(Integer.parseInt(id)); }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public String deleteStudentById(@PathVariable String id) {
        boolean isRemoved = this.studentService.deleteStudentById(Integer.parseInt(id));
        if (isRemoved) {
            return "Student has been deleted.";
        } else {
            return "Student was not found.";
        }
    }
}
