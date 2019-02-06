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
 class StoreUserFactory {
    public static StoreUser CreateUser(String type) {
    StoreUser user;

    switch (type) {
      case "Manager":
        return new Manager();
      case "Employee":
        return new Employee();
      case "Customer":
        return new Customer();
      default:
        // Yell at user
        return null;
        
    }
  }
    
    public static User CreateUser(String type, String name, String email, String password, String phoneNo, Address address) {
        StoreUser user = StoreUserFactory.CreateUser(type);
        
        user.Usertype = type;
        user.Name = name;
        user.EmailAddress = email.toLowerCase();
        user.Password = password;
        user.PhoneNumber = phoneNo;
        Address a = new Address(address.HouseNo, address.street, address.postCode);
        user.Address = a;
        return user;
    }
}
