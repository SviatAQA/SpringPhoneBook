package springcourse.phonebook.service;

import springcourse.phonebook.exception.UserContactAlreadyExistsException;
import springcourse.phonebook.exception.UserContactNotFoundException;
import springcourse.phonebook.model.UserContact;

import java.util.List;

public interface UserContactService {
    UserContact save(String contactName, List<String> phoneNumbers) throws UserContactAlreadyExistsException;

    List<UserContact> findAll();

    UserContact findByName(String contactName) throws UserContactNotFoundException;

    UserContact updateContact(String contactName, List<String> phoneNumbers) throws UserContactNotFoundException;

    void deleteContact(String contactName)  throws UserContactNotFoundException;
}
