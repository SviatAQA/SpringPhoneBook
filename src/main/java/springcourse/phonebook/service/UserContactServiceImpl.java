package springcourse.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcourse.phonebook.exception.UserContactAlreadyExistsException;
import springcourse.phonebook.exception.UserContactNotFoundException;
import springcourse.phonebook.model.UserContact;
import springcourse.phonebook.repository.UserContactRepository;

import java.util.List;

@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired
    private UserContactRepository userContactRepository;

    @Override
    public UserContact save(UserContact userContact) throws UserContactAlreadyExistsException {
        if (verifyExistingUserContact(userContact)) {
            throw new UserContactAlreadyExistsException();
        }
        userContactRepository.save(userContact);
        return userContact;
    }

    @Override
    public List<UserContact> findAll() {
        return userContactRepository.findAll();
    }

    @Override
    public UserContact findByName(String contactName) throws UserContactNotFoundException {
        return userContactRepository.findByContactName(contactName).orElseThrow(() -> new UserContactNotFoundException());
    }

    @Override
    public UserContact updateContact(UserContact userContact) throws UserContactNotFoundException {
        UserContact existingContact = findByName(userContact.getContactName());
        existingContact.setPhoneNumbers(userContact.getPhoneNumbers());
        userContactRepository.save(userContact);
        return userContact;
    }

    @Override
    public void deleteContact(String contactName) throws UserContactNotFoundException {
        UserContact userContact = findByName(contactName);
        userContactRepository.delete(userContact);
    }

    private boolean verifyExistingUserContact(UserContact userContact) {
        return userContactRepository.findByContactName(userContact.getContactName()).isPresent();
    }

}
