package springcourse.phonebook.service;

import springcourse.phonebook.exception.UserContactNotFoundException;
import springcourse.phonebook.model.UserContact;

import java.util.List;

public interface UserContactService {
    UserContact save(UserContact userContact);

    List<UserContact> findAll();

    UserContact findByName(String contactName) throws UserContactNotFoundException;

    UserContact updateContact(String contactName, String newPhone) throws UserContactNotFoundException;

    void deleteContact(String contactName)  throws UserContactNotFoundException;
}
