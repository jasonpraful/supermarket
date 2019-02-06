/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jason
 */

public class StoreOrder extends Order implements FilePersistence {

    
    
    public String username;
    public String Order;
    public Double orderTotal;
    public Date orderDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public void seeLoadFromFile(String filePath, String userName, JTextArea src) {
        // Load stuff from file
        
        src.setText("Hello,\n\nYour Recent Orders- ");
       

        try {
            Scanner sc; sc = new Scanner(new File(filePath));
            sc.useDelimiter("\n");
            
           while (sc.hasNext()) {
                String line = sc.next();
                String[] index = line.split("\\?");
                if(userName.equalsIgnoreCase(index[0])){
                    src.append("\n\nOrderPlaced on- "+sdf.parse(index[1])+
                            "\n\nConsisted of-\nProducts, Quantity, Price:  "+index[2]+"\nTotal Amount paid (With vat) - "+index[3]);
                    
                }
                // Index trim for branch addresses
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(StoreOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}