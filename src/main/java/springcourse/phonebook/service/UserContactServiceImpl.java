package springcourse.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcourse.phonebook.exception.UserContactNotFoundException;
import springcourse.phonebook.model.UserContact;
import springcourse.phonebook.repository.UserContactRepository;

import java.util.List;

@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired
    private UserContactRepository userContactRepository;
    @Override
    public UserContact save(UserContact userContact){
        userContactRepository.save(userContact);
        return userContact;
    }

    @Override
    public List<UserContact> findAll(){
        return userContactRepository.findAll();
    }

    @Override
    public UserContact findByName(String contactName) throws UserContactNotFoundException {
        return userContactRepository.findByContactName(contactName).orElseThrow(()-> new UserContactNotFoundException());
    }

    @Override
    public UserContact updateContact(String contactName, String newPhone) throws UserContactNotFoundException  {
        UserContact userContact = findByName(contactName);
        userContact.setPhoneNumber(newPhone);
        userContactRepository.save(userContact);
        return userContact;
    }

    @Override
    public void deleteContact(String contactName)  throws UserContactNotFoundException {
        UserContact userContact = findByName(contactName);
        userContactRepository.delete(userContact);
    }

}
