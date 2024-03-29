/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CCannon
 */
public class ContactList {
    
    private String listName;
    private ArrayList<Client> contacts;
    
    public ContactList(){
        
        listName = "";
        contacts = new ArrayList<>();
    
    }

    /**
     * @return the listname
     */
    public String getListName() {
        return listName;
    }

    /**
     * @param listname the listname to set
     */
    public void setListName(String listname) {
        this.listName = listname;
    }
    
    public Client getContact (int index){
        return contacts.get(index);
    }
    
    public int size(){
        return contacts.size();
    }
    
    public void deleteContact(int index){
        contacts.remove(index);
    }
    
    public void addContact(Client client){
        contacts.add(client);
    }
    
    public void loadContacts(String filename){
        try{
            Scanner read = new Scanner(new File(filename));
            listName = read.nextLine();
            while(read.hasNext()){
                String[] info = read.nextLine().split(",");
                Client client = new Client(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], info[5]);
                contacts.add(client);
            }
        }catch(FileNotFoundException ex){
            System.out.println("Cannot find file.");
        }
    
    }
    
    public void saveContacts(String filename){
    
        try{
            PrintWriter pw = new PrintWriter(new File(filename));
            pw.print(this.toString());
            pw.close();
            
        }catch(FileNotFoundException ex){
            System.out.println("File Could Not Be Written");
        }
    }
    
    @Override
    public String toString(){
        String s = "";
        
        for(int i = 0; i < size(); i++){
            s += contacts.get(i) + System.lineSeparator();
        }
        
        return listName + System.lineSeparator() + s;
    }
    
}
