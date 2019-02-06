/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


/**
 *
 * @author Jason
 */



public abstract class StoreUser extends User {
  public String Password;

  public enum UserType{
    MANAGER,
    EMPLOYEE,
    CUSTOMER,
    LOGIN_FAILED
}
  public UserType Login(String password) {
    if (this instanceof Manager) {
      return UserType.MANAGER;
    } else if (this instanceof Employee) {
      return UserType.EMPLOYEE;
    } else if (this instanceof Customer) {
      return UserType.CUSTOMER;
    }
    
    return UserType.LOGIN_FAILED;
  }
}