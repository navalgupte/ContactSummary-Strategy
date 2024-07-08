package org.example;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

/*
    OrganizationSummarizer - Returns summary with contact's organization, followed by their first and last name.
    Comparator class returns entries with ascending organization, then ascending last name.
 */
public class OrganizationSummarizer implements SummarizingStrategy {
    private Comparator comparator = new OrganizationComparator();

    public String summarize(Contact [] contactList) {
        StringBuffer product = new StringBuffer();
        Arrays.sort(contactList, comparator);
        for(Contact contact: contactList) {
            product.append(contact.getOrganization());
            product.append(DELIMITER);
            product.append(SPACE);
            product.append(contact.getFirstName());
            product.append(SPACE);
            product.append(contact.getLastName());
            product.append(EOL_STRING);
        }
        return product.toString();
    }

    public String [] makeSummarizedList(Contact [] contactList) {
        Arrays.sort(contactList, comparator);
        String [] product = new String[contactList.length];
        for(int i = 0; i < contactList.length; i++) {
            product[i] = contactList[i].getOrganization() + DELIMITER + SPACE +
                    contactList[i].getFirstName() +  SPACE + contactList[i].getLastName() + EOL_STRING;
        }
        return product;
    }

    private class OrganizationComparator implements Comparator {
        private Collator textComparator = Collator.getInstance();

        @Override
        public int compare(Object o1, Object o2) {
            Contact c1, c2;
            if((o1 instanceof Contact) && (o2 instanceof Contact)) {
                c1 = (Contact) o1;
                c2 = (Contact) o2;
                int compareResult = textComparator.compare(c1.getOrganization(), c2.getOrganization());
                if(compareResult == 0) {
                   compareResult = textComparator.compare(c1.getLastName(), c2.getLastName());
                }
                return compareResult;
            } else {
                return textComparator.compare(o1, o2);
            }
        }

        @Override
        public boolean equals(Object o) {
            return textComparator.equals(o);
        }
    }
}
