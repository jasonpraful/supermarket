/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class StoreUsers extends HashMap<String, StoreUser> implements FilePersistence {

    public void LoadFromFile(String filePath) {
        // Load stuff from file
        Scanner sc;

        try {
            sc = new Scanner(new File(filePath));
            sc.useDelimiter("\n");
            
           while (sc.hasNext()) {
                String line = sc.next();
                String[] index = line.split("\\$");

                Address address = new Address(Integer.parseInt(index[5]), index[6].trim(), index[7].trim());
                

                StoreUser user = (StoreUser)StoreUserFactory.CreateUser(index[0].trim(), index[1].trim(), index[2].trim(), index[3].trim(), index[4].trim(), address);
                this.put(user.EmailAddress, user);
                // Index trim for branch addresses
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SaveToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath,false);
            
            this.forEach((name, user) -> {
                String[] array = new String[] { user.Usertype, user.Name, user.EmailAddress.toLowerCase(), user.Password, user.PhoneNumber, Integer.toString(user.Address.HouseNo), user.Address.street, user.Address.postCode};
                String toString = String.join("$", array);
                try {
                    fw.write(toString + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(StoreUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
               fw.flush();
               fw.close();
        } catch (IOException ioe) {
            System.out.println("Failed to save");
        }
    }
    
    public StoreUser Search (String email){
        if (!this.containsKey(email)) {
            // Yell at user
            return null;
        }
        
        return this.get(email);        
    }
}
