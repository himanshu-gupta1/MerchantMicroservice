package com.example.MerchantMicroService.dto;

import com.example.MerchantMicroService.entity.Merchant;

public class MerchantProductDTO {

    private String merchantProductId;

    private int price;

    private int salePrice;

    private int stock;

    private String productId;

    private Merchant merchant;

   // private double merchantRating;



    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

//
//    public double getMerchantRating() {
//        return merchantRating;
//    }
//
//    public void setMerchantRating(double merchantRating) {
//        this.merchantRating = merchantRating;
//    }

    public String getMerchantProductId() {
        return merchantProductId;
    }

    public void setMerchantProductId(String merchantProductId) {
        this.merchantProductId = merchantProductId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
