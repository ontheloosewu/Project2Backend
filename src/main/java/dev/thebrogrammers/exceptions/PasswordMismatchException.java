package dev.thebrogrammers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) // tbh idk which code this would be.
public class PasswordMismatchException extends RuntimeException{
}
