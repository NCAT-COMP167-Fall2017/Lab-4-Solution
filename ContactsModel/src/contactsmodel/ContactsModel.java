/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsmodel;

/**
 *
 * @author CCannon
 */
public class ContactsModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactList cl = new ContactList();
        cl.loadContacts("contacts.txt");
        System.out.print(cl.toString());
    }
    
}
