/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Jason
 */
public class Cart extends ProductsList {

    protected double orderTotal = 0.0;
    protected double gTotal;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public Cart() {
        this.LoadFromFile("products.txt");
    }

    public int existsInTable(JTable table, String name) {
        // Get row and column count
        int rowCount = table.getRowCount();

        // Check against all entries
        for (int i = 0; i < rowCount; i++) {
            String currentEntry = table.getValueAt(i, 0).toString();

            if (currentEntry.equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    double vat = 0.0;

    public void addToCart(JTable src, String name, int orderQuantity, JLabel total, JLabel vatLabel, JLabel GrandTotal, JLabel newQuantity) {

        Product product = this.Search(name.toLowerCase());
        TableModel cartTable = src.getModel();
        int rowIdx = src.getRowCount();
        int tableQuantity = 0;
        double tablePrice = 0.0;

        if (product.Quantity < orderQuantity || orderQuantity == 0) {
            // Throw an error
            JOptionPane.showMessageDialog(null, "Order Quantity Not Valid");
        }

        double itemPrice = product.Price; // TODO get price from table fn - getPrice()
        double orderPrice = itemPrice * orderQuantity;

        int existingEntryIdx = existsInTable(src, name);
        if (existingEntryIdx >= 0) {
            rowIdx = existingEntryIdx;

            tableQuantity = (int) src.getValueAt(existingEntryIdx, 1);
            tablePrice = (double) src.getValueAt(existingEntryIdx, 2);

            product.Quantity -= orderQuantity;
            if (product.Quantity < product.MinimumQuantity) {
                newQuantity.setText("product Needs to be reordered");
            } else {
                newQuantity.setText(Integer.toString(product.Quantity));

            }
        } else {
            Vector row = new Vector();
            row.add(name);

            ((DefaultTableModel) cartTable).addRow(row);
        }

        int updatedQuantity = tableQuantity + orderQuantity;
        double updatedPrice = updatedQuantity * itemPrice;

        cartTable.setValueAt(updatedQuantity, rowIdx, 1);
        cartTable.setValueAt(updatedPrice, rowIdx, 2);

        orderTotal += orderQuantity * itemPrice;
        //Calculating the total
        total.setText(df2.format(orderTotal));
        vat = orderTotal * 0.2;
        vatLabel.setText(df2.format(vat));
        gTotal = orderTotal + vat;
        GrandTotal.setText(df2.format(gTotal));
    }

    public double getGrandTotal() {

        return gTotal;
    }

}
