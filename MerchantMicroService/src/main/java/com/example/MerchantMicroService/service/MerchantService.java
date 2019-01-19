package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.entity.MerchantProduct;

public interface MerchantService {

    public void addMerchant(Merchant merchant);

    public void deleteMerchant(String id);

    public Merchant getMerchant(String id);

    public void updateMerchant(Merchant merchant);

}
