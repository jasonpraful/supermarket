/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.Date;

/**
 *
 * @author Jason
 */
class StoreProductFactory extends Product {

    public static Product CreateProduct(String type) {
        Product prod;
        return null;

    }

    public Product CreateProduct(String Category, int ID, String ProductName, Double price, Integer quantity, Integer minQuantity, Integer maxQuantity,
            Double weight, Date expiry, String manufacturer, String imageFilePath) {

        this.Category = Category;
        this.ID = ID;
        this.Price = price;
        this.Name = ProductName.toLowerCase();
        this.Quantity = quantity;
        this.MinimumQuantity = minQuantity;
        this.MaximumQuantity = maxQuantity;
        this.Weight = weight;
        this.ExpiryDate = expiry;
        this.Manufacturer = manufacturer;
        this.ImageFilePath = imageFilePath;
        return null;
    }

}
