package id.web.hikmasoft.aseton.api.api;

import id.web.hikmasoft.aseton.api.exception.ApplicationError;
import id.web.hikmasoft.aseton.api.exception.BarangExistException;
import id.web.hikmasoft.aseton.api.exception.BarangNotFoundException;
import id.web.hikmasoft.aseton.api.exception.BarangNullException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(BarangNotFoundException.class)
    public ResponseEntity<ApplicationError> handleBarangNotFoundException(BarangNotFoundException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BarangExistException.class)
    public ResponseEntity<ApplicationError> handleBarangExistException(BarangExistException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(102);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BarangNullException.class)
    public ResponseEntity<ApplicationError> handleBarangNullRequest(BarangNullException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(103);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
