package dev.thebrogrammers.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.thebrogrammers.entities.Grade;
import dev.thebrogrammers.exceptions.InsufficientPermissionException;
import dev.thebrogrammers.exceptions.UnauthenticatedException;
import dev.thebrogrammers.services.GradeService;
import dev.thebrogrammers.services.JwtService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class GradeController {

    @Autowired
    JwtService jwtService;
    @Autowired
    GradeService gradeService;

    @PostMapping("/grades")
    @ResponseBody
    public ResponseEntity<Grade> registerGrade(@RequestHeader("auth") String jwt, @RequestBody Grade body) {

        String role = validateJWT(jwt);
        if (role.equals("teacher")) {
            Grade savedGrade = this.gradeService.registerGrade(body);
            return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);
        } else {
            throw new InsufficientPermissionException();
        }
    }

    @GetMapping("/grades/{id}")
    @ResponseBody
    public List<Grade> getGradesByStudentId(@RequestHeader("auth") String jwt, @PathVariable String id) {

        String role = validateJWT(jwt);
        if (role.equals("teacher") || role.equals("guardian")) {
            int sId = Integer.parseInt(id);
            return this.gradeService.getGradesByStudentId(sId);
        } else {
            throw new InsufficientPermissionException();
        }
    }

    @DeleteMapping("/grades/{id}")
    @ResponseBody
    public String deleteGradeById(@RequestHeader("auth") String jwt, @PathVariable String id) {

        String role = validateJWT(jwt);
        if (role.equals("teacher")) {
            boolean isRemoved = this.gradeService.deleteGradeById(Integer.parseInt(id));
            if (isRemoved) {
                return JSONObject.quote("Grade has been deleted.");
            } else {
                return JSONObject.quote("Grade was not found.");
            }
        } else {
            throw new InsufficientPermissionException();
        }


    }

    @DeleteMapping("/grades")
    @ResponseBody
    public Long deleteGradesByStudentId(@RequestHeader("auth") String jwt, @RequestParam String sId) {

        String role = validateJWT(jwt);
        if (role.equals("teacher")) {
            return this.gradeService.deleteGradesByStudentId(Integer.parseInt(sId));
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
