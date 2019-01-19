package com.example.MerchantMicroService.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name=Merchant.TABLE_NAME)
public class Merchant {


    //public final static String TABLE_NAME="Merchant";
    //public static final String ID_COLUMN="ID";



    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    //@Column(name=Merchant.ID_COLUMN)
    private String merchantId;

    private String merchantName;
    private String merchantCity;
    private double merchantRating;

    @JsonBackReference
    @OneToMany(
            mappedBy = "merchant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MerchantProduct> merchantProductList;



    public List<MerchantProduct> getMerchantProductList() {
        return merchantProductList;
    }

    public void setMerchantProductList(List<MerchantProduct> merchantProductList) {
        this.merchantProductList = merchantProductList;
    }

    public double getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(double merchantRating) {
        this.merchantRating = merchantRating;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }
}
