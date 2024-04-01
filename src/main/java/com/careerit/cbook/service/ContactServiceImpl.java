package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact addContact(Contact contact) {
        if (contact.getCid() == null) {
            contact.setCid(UUID.randomUUID());
        }
        contacts.add(contact);
        log.info("Contact added successfully with cid : {}", contact.getCid());
        return contact;
    }

    @Override
    public Contact updateContact(Contact contact) {
        if (contact.getCid() != null) {
            for (Contact c : contacts) {
                if (c.getCid().equals(contact.getCid())) {
                    c.setName(contact.getName());
                    c.setEmail(contact.getEmail());
                    c.setMobile(contact.getMobile());
                    log.info("Contact updated successfully with cid : {}", contact.getCid());
                    return c;
                }
            }
        }
        log.error("Contact not found with cid : {}", contact.getCid());
        throw new IllegalArgumentException("Contact not found with cid : " + contact.getCid());
    }

    @Override
    public boolean deleteContact(UUID cid) {

        for (Contact c : contacts) {
            if (c.getCid().equals(cid)) {
                contacts.remove(c);
                log.info("Contact deleted successfully with cid : {}", cid);
                return true;
            }
        }
        log.error("Contact not found with cid : {}", cid);
        return false;

    }

    @Override
    public Contact getContact(UUID cid) {
        for (Contact c : contacts) {
            if (c.getCid().equals(cid)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Contact not found with cid : " + cid);
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public List<Contact> search(String str) {
        List<Contact> searchContacts = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().contains(str) || c.getEmail().contains(str) || c.getMobile().contains(str)) {
                searchContacts.add(c);
            }
        }
        return searchContacts;
    }

    @Override
    public void deleteAll() {
        contacts.clear();
    }
}
