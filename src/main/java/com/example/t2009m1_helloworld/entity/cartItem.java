package com.example.t2009m1_helloworld.entity;

public class cartItem {
    public Object CartItemBuilder;
    private int productId;
    private String productName;
    private String productThumbnail;
    private double unitPrice;
    private int quantity;
    @Override
    public String toString(){
        return  String.format("%s - %.2f - %d", productName, unitPrice, quantity);
    }

    public cartItem() {

    }

    public Object getproductName() {
    }

    public double getUnitPrice() {
    }

    public Object getQuantity() {
    }

    public Object getProductId() {
    }
}
