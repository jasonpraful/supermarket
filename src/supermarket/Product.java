/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Jason
 */

public abstract class Product {
  public String Name;
  public String Category;
public int ID;
  public Date ExpiryDate;
  public String Manufacturer;
  public double Price;
  public double Weight;
public int Quantity;
  public int MinimumQuantity;
  public int MaximumQuantity;
  public String ImageFilePath;
  
}