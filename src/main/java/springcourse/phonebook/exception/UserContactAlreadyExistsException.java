package springcourse.phonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserContactAlreadyExistsException extends RuntimeException {
    public UserContactAlreadyExistsException() {
        super();
    }
}
