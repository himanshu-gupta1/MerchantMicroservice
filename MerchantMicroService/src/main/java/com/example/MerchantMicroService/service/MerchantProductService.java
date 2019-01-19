package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.entity.MerchantProduct;

public interface MerchantProductService {

    public void addMerchantProduct(MerchantProduct merchantProduct);

    public void deleteMerchantProduct(String id);

    public MerchantProduct getMerchantProduct(String id);

    public void updateMerchantProduct(MerchantProduct merchantProduct);
}
