package com.mis.service;

import com.mis.entity.Contact;
import com.mis.entity.Email;
import com.mis.entity.PhoneNumbers;
import com.mis.repository.ContactRepository;
import com.mis.repository.PhoneNumbersRepository;
import com.mis.repository.emailrepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;

    @Autowired
    emailrepository emailRepository;


    Logger logger = LoggerFactory.getLogger(ContactService.class);

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public ResponseEntity<String> addContact(Contact c) {
        try {
            contactRepository.save(c);
            return new ResponseEntity<>("data saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid data", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }

    public List<PhoneNumbers> findByPhonenumber(String phonenumber) {
        return phoneNumbersRepository.findByPhoneNumber(phonenumber);
    }

    public List<Contact> findbyemail(String email) {

        List<Email> lem = emailRepository.findbyemail(email);
        List<Contact> cl = new ArrayList<>();
        for (Email em : lem) {
            cl.add(findById(em.getId()));
        }
        return cl;
    }

    public ResponseEntity<String> deleteContact(Long id) {
        if (contactRepository.findById(id).isPresent()) {
            contactRepository.deleteById(id);
            return new ResponseEntity<>("Data deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id not present in database", HttpStatus.BAD_REQUEST);
    }

    public Contact findById(long id) {
        Optional<Contact> c = contactRepository.findById(id);
        if (c.isPresent()) {
            return c.get();
        }
        return null;
    }

}
