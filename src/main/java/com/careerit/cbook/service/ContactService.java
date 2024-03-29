package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;

import java.util.List;

public interface ContactService {

        public Contact addContact(Contact contact);
        public Contact updateContact(Contact contact);
        public boolean deleteContact(long cid);
        public Contact getContact(long cid);
        public List<Contact> getContacts();
        public List<Contact> search(String str);
        public void deleteAll();
}
