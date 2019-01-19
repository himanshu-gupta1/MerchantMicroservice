package com.example.MerchantMicroService.dto;

import com.example.MerchantMicroService.entity.MerchantProduct;

import java.util.List;

public class MerchantDTO {

    private String merchantId;

    private String merchantName;
    private String merchantCity;
    private double merchantRating;

    private List<MerchantProduct> merchantProductList;

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

    public double getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(double merchantRating) {
        this.merchantRating = merchantRating;
    }

    public List<MerchantProduct> getMerchantProductList() {
        return merchantProductList;
    }

    public void setMerchantProductList(List<MerchantProduct> merchantProductList) {
        this.merchantProductList = merchantProductList;
    }
}
