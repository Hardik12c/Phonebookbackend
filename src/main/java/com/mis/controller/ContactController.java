package com.mis.controller;

import com.mis.entity.Contact;
import com.mis.entity.PhoneNumbers;
import com.mis.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PB")
public class ContactController {

    @Autowired
    ContactService service;

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/hi")
    public String hello(){
        return "lets get to work";
    }

    @GetMapping("/findbyname/{name}")
    public List<Contact> getbyname(@PathVariable("name") String name){
        return service.findByName(name);
    }
    @GetMapping("/findbyphone/{phonenumber}")
    public Contact getbyphonenumber(@PathVariable("phonenumber") String phonenumber){
        List<PhoneNumbers> l = service.findByPhonenumber(phonenumber);
        return service.findById(l.get(0).getId());

    }
    @GetMapping("/findbyemail/{email}")
    public List<Contact> getbyemail(@PathVariable("email") String email){
        return service.findbyemail(email);

    }
    @GetMapping("/getAll")
    public List<Contact> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Contact c){
        return service.addContact(c);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> del(@PathVariable("id") Long id){
        return service.deleteContact(id);
    }


}
