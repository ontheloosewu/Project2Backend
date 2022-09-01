package dev.thebrogrammers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Name must be in the format: 'first last')")
public class InvalidNameFormatException extends RuntimeException{
}
