package com.example.MerchantMicroService.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//@Table(name="Merchant_product")
public class MerchantProduct {



    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private String merchantProductId;

    private int price;
    private int stock;

    private String productId;


    //@JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;


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
