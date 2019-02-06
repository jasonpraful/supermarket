/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;

/**
 *
 * @author Jason
 */


public class Customer extends StoreUser {
  public ArrayList<Product> WishList;
  public ArrayList<StoreOrder> Orders;
  public Cart Cart;
}
