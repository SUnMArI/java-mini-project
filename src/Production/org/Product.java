package Production.org;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Product {
    private int ID ;
    private String productName ;
    private double productPrice;
    private int quantity;
    private LocalDate Date;

    public Product(){};

    public Product(int ID, String productName, double productPrice, int quantity, LocalDate date) {
        this.ID = ID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        Date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
