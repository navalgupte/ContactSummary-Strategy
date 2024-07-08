package org.example;

import java.io.File;

public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Strategy Pattern");
        System.out.println("---- ---- ---- ---- ----");
        System.out.println("Deserializing stored ContactList..");
        if(!(new File("data.ser")).exists()) {
           DataCreator.serilize("data.ser");
        }
        ContactList list = (ContactList) (DataRetriever.deserializeData("data.ser"));
        System.out.println();
        System.out.println("Creating NameSummarizer for ContactList");
        list.setSummarizer(new NameSummarizer());
        System.out.println("NameSummarizer output for ContactList");
        System.out.println(list.summarize());
        System.out.println("---- ---- ---- ---- ----");
        System.out.println("Creating OrganizationSummarizer for ContactList");
        list.setSummarizer(new OrganizationSummarizer());
        System.out.println("OrganizationSummarizer output for ContactList");
        System.out.println(list.summarize());
        System.out.println("---- ---- ---- ---- ----");
    }
}