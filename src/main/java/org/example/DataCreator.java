package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataCreator {
    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String [] args) {
        String fileName;
        if(args.length == 1) {
            fileName = args[0];
        } else {
            fileName = DEFAULT_FILE;
        }
        serilize(fileName);
    }

    public static void serilize(String fileName) {
        try {
            serializeToFile(makeContactList(), fileName);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static Serializable makeContactList() {
        ContactList list = new ContactList();

        list.addContact(new ContactImpl("David", "St. Hubbins", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Mick", "Shrimpton", "Drummer", "The New Originals"));
        list.addContact(new ContactImpl("Nigel", "Tufnel", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Derek", "Smalls", "Bass", "The New Originals"));
        list.addContact(new ContactImpl("Viv", "Savage", "Keyboards", "The New Originals"));
        list.addContact(new ContactImpl("Nick", "Shrimpton", "CEO", "Fishy Business Ltd."));
        list.addContact(new ContactImpl("Nikolai", "Lobachevski", "Sr. Packer", "Fishy Business Ltd."));
        list.addContact(new ContactImpl("Alan", "Robertson", "Comptroller", "Universal Exports"));
        list.addContact(new ContactImpl("William", "Telle", "President", "Universal Exports"));
        list.addContact(new ContactImpl("Harvey", "Spectre", "Sr. Partner", "Zane Spectre"));
        list.addContact(new ContactImpl("Diedre", "Pine", "Chief Mechanic", "Universal Repairs"));
        list.addContact(new ContactImpl("Martha", "Zane", "Lead Developer", "Avatar Inc."));
        list.addContact(new ContactImpl("Bryan", "Cranston", "CTO", "IOVA"));

        return list;
    }

    private static void serializeToFile(Serializable content, String fileName) throws IOException {
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}
