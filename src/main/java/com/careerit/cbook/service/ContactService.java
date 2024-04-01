package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {

        public Contact addContact(Contact contact);
        public Contact updateContact(Contact contact);
        public boolean deleteContact(UUID cid);
        public Contact getContact(UUID cid);
        public List<Contact> getContacts();
        public List<Contact> search(String str);
        public void deleteAll();
}
