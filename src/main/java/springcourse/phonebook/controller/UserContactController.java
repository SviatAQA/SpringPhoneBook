package springcourse.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springcourse.phonebook.exception.UserContactNotFoundException;
import springcourse.phonebook.model.UserContact;
import springcourse.phonebook.service.UserContactService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserContactController {

    @Autowired
    private UserContactService userContactService;

    @PostMapping("/contacts/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public UserContact createUser(@RequestBody UserContact userContact) {
        return userContactService.save(userContact);
    }

    @PutMapping(path = "/contacts/{userContactName}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public UserContact updateContactByName(@PathVariable("userContactName") String userContactName,
                                           @RequestParam(name = "phoneNumber") String phoneNumber) {
        try {
            return userContactService.updateContact(userContactName, phoneNumber);
        } catch (UserContactNotFoundException exc) {
            throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, "Such contact is not present: " + userContactName );
        }
    }

    @DeleteMapping(path = "/contacts/{userContactName}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public void deleteContactByName(@PathVariable("userContactName") String userContactName) {
        try {
            userContactService.deleteContact(userContactName);
        } catch (UserContactNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Such contact is not present: " + userContactName);
        }
    }

    @GetMapping(path = "/contacts")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public List<UserContact> getAllUserContacts() {
        return userContactService.findAll();
    }

    @GetMapping(path = "/contacts/{userContactName}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public UserContact getContactByName(@PathVariable("userContactName") String userContactName) {
        try {
            return userContactService.findByName(userContactName);
        } catch (UserContactNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Such contact is not present: " + userContactName);
        }
    }

}
