package com.official.nanorus.contacts.model.domain;

import com.official.nanorus.contacts.entity.contact.Contact;
import com.official.nanorus.contacts.model.data.database.DatabaseManager;
import com.official.nanorus.contacts.model.repository.ContactsRepository;

import java.util.List;

import rx.Observable;

public class ContactsInteractor {

    private static ContactsInteractor instance;

    public static ContactsInteractor getInstance() {
        if (instance == null)
            instance = new ContactsInteractor();
        return instance;
    }

    private ContactsRepository repository;

    public ContactsInteractor() {
        repository = ContactsRepository.getInstance();
    }

    public Observable<List<Contact>> getContacts() {
        return repository.getContacts();
    }

    public void addContact(Contact contact, DatabaseManager.SuccessListener successListener) {
        repository.addContact(contact, successListener);
    }

    public void saveContactPhoto(String image, String photoFileName) {
        repository.saveContactPhoto(image, photoFileName);
    }

    public int getLastMenuItem() {
        return repository.getLastMenuItem();
    }

    public void setLastMenuItem(int item) {
        repository.setLastMenuItem(item);
    }

    public void deleteContact(int id, DatabaseManager.SuccessListener successListener) {
        repository.deleteContact(id, successListener);
    }

    public void clearContacts(DatabaseManager.SuccessListener successListener) {
        repository.clearContacts(successListener);
    }
}