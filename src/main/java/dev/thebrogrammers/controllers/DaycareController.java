package dev.thebrogrammers.controllers;

import dev.thebrogrammers.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaycareController {

    @Autowired
    StudentService studentService;

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
