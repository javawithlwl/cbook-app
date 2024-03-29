package com.careerit.cbook.controller;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

        @Autowired
        private ContactService contactService;
        @PostMapping
        public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
            Contact addedContact = contactService.addContact(contact);
            return ResponseEntity.ok(addedContact);
        }

        @PutMapping
        public ResponseEntity<Contact> updateContact(@RequestBody Contact contact){
            Contact updatedContact = contactService.updateContact(contact);
            return ResponseEntity.ok(updatedContact);
        }

        @DeleteMapping("/{cid}")
        public ResponseEntity<String> deleteContact(@PathVariable("cid") long cid){
            boolean isDeleted = contactService.deleteContact(cid);
            if(isDeleted){
                return ResponseEntity.ok("Contact deleted successfully");
            }else{
                return ResponseEntity.badRequest().body("Contact not found with cid : "+cid);
            }
        }

        @GetMapping("/{cid}")
        public ResponseEntity<Contact> getContact(@PathVariable("cid") long cid){
            Contact contact = contactService.getContact(cid);
            return ResponseEntity.ok(contact);

        }

        @GetMapping("/search/{str}")
        public ResponseEntity<List<Contact>> search(@PathVariable("str") String str){
            List<Contact> contacts = contactService.search(str);
            return ResponseEntity.ok(contacts);
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll(){
            contactService.deleteAll();
            return ResponseEntity.ok("All contacts deleted successfully");
        }
        @GetMapping("/all")
        public ResponseEntity<List<Contact>> getContacts(){
            List<Contact> contacts = contactService.getContacts();
            return ResponseEntity.ok(contacts);
        }

        @GetMapping("/hello")
        public String hello(){
            return "Hello from Spring Boot";
        }

}
