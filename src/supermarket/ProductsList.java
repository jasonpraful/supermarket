/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Jason
 */

// ProductsList list copy


public class ProductsList extends HashMap<String, Product> implements FilePersistence {
  
   public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  public void LoadFromFile(String filePath) {
        // Load stuff from file
        Scanner sc;

        try {
            sc = new Scanner(new File(filePath));
            sc.useDelimiter("\n");
            
           while (sc.hasNext()) {
                String line = sc.next();
                String[] index = line.split("\\$");
                StoreProductFactory product = new StoreProductFactory();
                Date date = sdf.parse(index[8]);
                product.CreateProduct(index[0].trim(), Integer.parseInt(index[1].trim()), index[2].trim(),
                        Double.parseDouble(index[3].trim()), 
                        Integer.parseInt(index[4].trim()), Integer.parseInt(index[5].trim()),Integer.parseInt(index[6].trim()),
                        Double.parseDouble(index[7]), date, index[9].trim(), index[10]);
                this.put(product.Name, product);
                // Index trim for branch addresses
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
          Logger.getLogger(ProductsList.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  
  
    public void SaveToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath,false);
            
            this.forEach((name, product) -> {
                String[] array = new String[] {product.Category,Integer.toString(product.ID), product.Name, Double.toString(product.Price), Integer.toString(product.Quantity), Integer.toString(product.MinimumQuantity),
                    Integer.toString(product.MaximumQuantity), Double.toString(product.Weight), sdf.format(product.ExpiryDate).toString(), product.Manufacturer, product.ImageFilePath};
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
    
    
    
    public Product Search(String Name){
    
    if (!this.containsKey(Name)) {
            // Yell at user
            return null;
        }
    
    return this.get(Name);   
    
    }
    
  
    
    
    
    
    
}
