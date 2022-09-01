package dev.thebrogrammers.controllers;

import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/grades")
    @ResponseBody
    public ResponseEntity<Grade> registerGrade(@RequestBody Grade body) {
        Grade savedGrade = this.gradeService.registerGrade(body);
        return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);
    }
}
