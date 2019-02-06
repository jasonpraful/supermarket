/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jason
 */
public class Order implements FilePersistence {

    public ArrayList<ProductOrder> OrderedProducts;
    public static String mailOrder;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    Cart value = new Cart();
    
    public double TotalPrice() {

        return 0.0;

    }

    public void Checkout(JTable src, String filePath, String eMail, String userName,JLabel total) {
        Double GorderTotal = Double.parseDouble(total.getText());
        mailOrder = "<h3>Hi," + userName + "</h3>";
        try {
            FileWriter fw = new FileWriter(filePath, true);
            DefaultTableModel model = new DefaultTableModel();
            int rows = src.getRowCount();
            fw.write(eMail + "?"+ dateFormat.format(date)+"?");
            mailOrder += "<p style=\"margin-bottom:0;\">Your Order consists of:- \n</p>";
            
                 mailOrder += "<table border=\"1\">";
                 mailOrder += "<th>Product Name</th><th>Quantity</th><th>Price</th>";
            for (int i = 0; i < rows; i++) {
                
                 mailOrder += "<tr>";
                 
                fw.write((String) src.getModel().getValueAt(i, 0) + ",");
                 fw.write((int) src.getModel().getValueAt(i, 1) + ",");
                 fw.write((Double) src.getModel().getValueAt(i, 2) + ",");
               
                 mailOrder += "<td><p style=\"margin : 0; padding-top:5;\"> " + src.getModel().getValueAt(i, 0) + "</p></td>";
                mailOrder += "<td><p style=\"margin : 0; padding-top:0;\"> " + src.getModel().getValueAt(i, 1) + "</p></td>";
                mailOrder += "<td><p style=\"margin : 0; padding-top:0;\">" + src.getModel().getValueAt(i, 2) + "</p></td> \n\n";

                 mailOrder += "</tr>";
            }
                 mailOrder += "</table>";
                 
            fw.write("?"+GorderTotal + "\n");
            mailOrder += "<h3>Your order total amounted to-  £" + GorderTotal+"</h3>";
            mailOrder += "\n\n\n<h3>Thank you for shopping with us! Have a great day ahead!</h3>";
            System.out.println(mailOrder);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getOrderMessage() {
        return mailOrder;
    }

    @Override
    public void SaveToFile(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LoadFromFile(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
