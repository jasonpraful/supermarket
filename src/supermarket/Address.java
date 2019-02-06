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
public class Address {

    public int HouseNo;
    public String street;
    public String postCode;

    public Address(int houseNo, String street, String postCode) {
        this.HouseNo = houseNo;
        this.street = street;
        this.postCode = postCode;
    }

}
