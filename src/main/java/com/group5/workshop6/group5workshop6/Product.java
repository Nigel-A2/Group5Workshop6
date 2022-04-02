package com.group5.workshop6.group5workshop6;

import java.io.Serializable;

// this is for the database table
public class Product implements Serializable {
    private int productId;
    private String prodName;

    public Product(int productId, String prodName) {
        this.productId = productId;
        this.prodName = prodName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    @Override
    public String toString() {
        return productId + "";
    }
}
