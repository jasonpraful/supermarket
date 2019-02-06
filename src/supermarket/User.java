/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;
import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Jason Francis
 */
public abstract class User {
  
    public String Usertype;
    public String Name;
  public Address Address;
  public String PhoneNumber;
  public String EmailAddress;
  
//    private variables
//    String UserType;
//            String Name;
//            String Email;
//            String Phone;
//            String UserName;
//            String Password;
//            int HouseNo;
//            String Street;
//            String Postcode;
//            private ArrayList <user> userAccounts;
//            private String customerList = "customers.txt";
////    file management
//    FileReader areader;
//    
////    Accounts management
//    private user userAccount;
//    
//    public user(){
//        UserType = "";
//        Name = "";
//        Email = "";
//        Phone = "";
//        UserName = "";
//        Password = "";
//        HouseNo = 0;
//        Street = "";
//        Postcode = "";
//        
//        
//    }
//    
//    public user(String UserType, String Name, String Email, String Phone, String UserName, String Password, int HouseNo, String Street,String Postcode){
//          this.Edit(UserType, Name,Email,Phone,UserName,Password,HouseNo,Street,Postcode);
//    }
//    
//    public void Edit(String aUserType,String aName, String aEmail, String aPhone, String aUserName, String aPassword,int  aHouseNo, String aStreet, String aPostcode){
//        UserType = aUserType;
//        Name = aName;
//        Email = aEmail;
//        Phone = aPhone;
//        UserName = aUserName;
//        Password = aPassword;
//        HouseNo = aHouseNo;
//        Street = aStreet;
//        Postcode = aPostcode;
//    }
//    
//    
//    @Override
//    public String toString(){
//        return (UserType+ "," + Name +","+ Email + ","+ Phone + "," + UserName + "," + Password + "," + HouseNo + "," + Street + "," + Postcode + "/");
//    }
//    
//    public void SaveToFile(FileWriter aWriter){
//         try {
//            aWriter.write(toString());
//          
//        } catch (IOException ioe){
//            System.out.println("Failed to save");
//        }   
//    }
//    
//    public void LoadFromFile(BufferedReader bin){
//        try {
//            UserType = bin.readLine();
//            UserName = bin.readLine();
//            Password = bin.readLine();
//            Name = bin.readLine();
//            Email = bin.readLine();
//            Phone = bin.readLine();
//            HouseNo = Integer.parseInt(bin.readLine());
//            Street = bin.readLine();
//            Postcode = bin.readLine();
//        }catch(IOException ioe){
//            
//        }  
//    }
//    
//    
//    
//   
}
