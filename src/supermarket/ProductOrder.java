/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Jason
 */

public class ProductOrder extends ProductsList {
  public Product Product;
  public int Quantity;

  double orderTotal = 0;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static DecimalFormat df2 = new DecimalFormat(".##");
  
    public ProductOrder(){
        super.LoadFromFile("products.txt");
    }
   //Adding all products to product list
    public void AddProductToList(JList src) {
        super.LoadFromFile("products.txt");
        DefaultListModel dlm = new DefaultListModel();
        super.forEach((name, Product) -> {
            dlm.addElement(StringUtils.capitalize(name));
        });

        src.setModel(dlm);
    }

    //Adding products according to category
    public void AddProductToListCategory(String Category, JList src) {
        super.LoadFromFile("products.txt");
        DefaultListModel dlm = new DefaultListModel();
        super.entrySet().stream()
                .filter(item -> item.getValue().Category.equals(Category))
                .forEach(item -> dlm.addElement(item.getKey()));

        src.setModel(dlm);
    }

    
    
    // Change Image dynamically
    public void dynamicImageUpdate(String name, JLabel b, JSpinner c, JLabel d, JLabel e) {
        Product product = super.Search(name.toLowerCase());
        b.setText(name);
        if (product.Quantity < product.MinimumQuantity) {
            d.setText("Needs to be reordered");
        } else {
            d.setText(Integer.toString(product.Quantity));
        }
        e.setText(Double.toString(product.Price));
    }

    //Search for product
    public void Search(String name, JList src) {
        super.LoadFromFile("products.txt");
        DefaultListModel dlm = new DefaultListModel();
        Product product = super.Search(name);
        String aname = "";
        dlm.addElement(product.Name);
        src.setModel(dlm);

    }



  
  
}