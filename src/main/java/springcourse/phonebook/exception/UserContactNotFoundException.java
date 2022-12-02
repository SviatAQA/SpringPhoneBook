package springcourse.phonebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserContactNotFoundException extends RuntimeException {
    public UserContactNotFoundException() {
        super();
    }
}
