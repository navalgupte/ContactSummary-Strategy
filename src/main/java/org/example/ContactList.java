package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable {
    private ArrayList contacts = new ArrayList();
    private SummarizingStrategy summarizer;

    public ArrayList getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
    }

    public Contact [] getContactsAsArray() {
        return (Contact[]) contacts.toArray(new Contact [1]);
    }

    public void setSummarizer(SummarizingStrategy summarizer) {
        this.summarizer = summarizer;
    }

    public void addContact(Contact contact) {
        if(!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public String summarize() {
        return summarizer.summarize(getContactsAsArray());
    }

    public String [] makeSummarizedList() {
        return summarizer.makeSummarizedList(getContactsAsArray());
    }
}
