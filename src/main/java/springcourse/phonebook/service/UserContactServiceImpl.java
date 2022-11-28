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
    public UserContact save(String contactName, List<String> phoneNumbers) throws UserContactAlreadyExistsException {
        if (verifyExistingUserContact(contactName)) {
            throw new UserContactAlreadyExistsException();
        }
        UserContact newContact = new UserContact();
        newContact.setContactName(contactName);
        newContact.setPhoneNumbers(phoneNumbers);
        userContactRepository.save(newContact);
        return newContact;
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
    public UserContact updateContact(String contactName, List<String> phoneNumbers) throws UserContactNotFoundException {
        UserContact existingContact = findByName(contactName);
        existingContact.setPhoneNumbers(phoneNumbers);
        userContactRepository.save(existingContact);
        return existingContact;
    }

    @Override
    public void deleteContact(String contactName) throws UserContactNotFoundException {
        UserContact userContact = findByName(contactName);
        userContactRepository.delete(userContact);
    }

    private boolean verifyExistingUserContact(String userContact) {
        return userContactRepository.findByContactName(userContact).isPresent();
    }

}
