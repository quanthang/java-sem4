package com.example.t2009m1_helloworld.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shoppingcart {
    private double totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private HashMap<Integer, cartItem> items;
    private cartItem item;

    public Shoppingcart(){
        items = new HashMap<>();
    }
    public List<cartItem> getListItems(){return  new ArrayList<>(items.values());}
    public boolean add(Product product, int quantity) {
        cartItem cartItem = null;
        if (items.containsKey(product.getId())){
            cartItem = items.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }else {
            cartItem = cartItem.CartItemBuilder.aCartItem()
                    .productId(product.getId())
                    .productName(product.getName())
                    .productThumbnail(product.getThumbnail())
                    .unitPrice(product.getPrice())
                    .quantity(quantity)
                    .build();
    }
        items.put(product.getId(), cartItem);
        return true;
}
public boolean sub(Product product, int quantity){
        cartItem cartItem = null;
        if (items.containsKey(product.getId())){
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if (updateQuantity <= 0){
                items.remove((product.getId()));
            }else {
                cartItem.setQuantity(updateQuantity);
            }
        }
        return true;
}
public boolean remove(int productId){
        if (items.containsKey(productId)){
            items.remove(productId);
            return true;
        }
        return false;
}
public  void clear(){items.clear();}
    public double getTotalPrice(){
        if (items.size()==0){
            return 0;
        }
        totalPrice = 0;
        for (cartItem :
        getListItems()){
            totalPrice += items.getunitPrice() * item.getQuantity();
        }
        return  totalPrice;
    }
}