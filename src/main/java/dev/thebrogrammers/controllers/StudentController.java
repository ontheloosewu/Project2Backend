package dev.thebrogrammers.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.thebrogrammers.entities.Student;
import dev.thebrogrammers.exceptions.InsufficientPermissionException;
import dev.thebrogrammers.exceptions.UnauthenticatedException;
import dev.thebrogrammers.repos.StudentRepo;
import dev.thebrogrammers.services.JwtService;
import dev.thebrogrammers.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin
public class StudentController {

    @Autowired
    JwtService jwtService;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<Student> registerStudent(@RequestHeader("auth") String jwt, @RequestBody Student body) {

        String role = validateJWT(jwt);

        if (role.equals("teacher")) {
            return new ResponseEntity<Student>(this.studentService.registerStudent(body), HttpStatus.CREATED);
        } else {
            throw new InsufficientPermissionException();
        }

    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentById(@RequestHeader("auth") String jwt, @PathVariable String id) {

        String role = validateJWT(jwt);

        if (role.equals("teacher") || role.equals("guardian")) {
            return this.studentService.getStudentById(Integer.parseInt(id));
        } else {
            throw new InsufficientPermissionException();
        }

    }


    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents(@RequestHeader("auth") String jwt) {

        String role = validateJWT(jwt);

        if (role.equals("teacher")) {
            return this.studentRepo.findAll();
        } else {
            throw new InsufficientPermissionException();
        }
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public String deleteStudentById(@RequestHeader("auth") String jwt, @PathVariable String id) {


        String role = validateJWT(jwt);
        if (role.equals("teacher")) {
            boolean isRemoved = this.studentService.deleteStudentById(Integer.parseInt(id));
            if (isRemoved) {
                return "Student has been deleted.";
            } else {
                return "Student was not found.";
            }
        } else {
            throw new InsufficientPermissionException();
        }
    }

    public String validateJWT(String jwt) {
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt); // take it out of base64
            return decodedJWT.getClaim("role").asString();
        }
        throw new UnauthenticatedException();
    }

}
