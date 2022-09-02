package dev.thebrogrammers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Unable to find student")
public class StudentNotFoundException extends RuntimeException{
}
