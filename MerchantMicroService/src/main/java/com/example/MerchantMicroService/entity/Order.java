package com.example.MerchantMicroService.entity;

public class Order {


    private String productId;
    private String merchantId;
    private int pcnt;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getPcnt() {
        return pcnt;
    }

    public void setPcnt(int pcnt) {
        this.pcnt = pcnt;
    }


    @Override
    public String toString() {
        return "Order{" +
                "productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", pcnt=" + pcnt +
                '}';
    }
}
