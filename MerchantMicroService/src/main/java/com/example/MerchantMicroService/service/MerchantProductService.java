package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.dto.MerchantDTO;
import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.entity.MerchantProduct;

import java.util.List;

public interface MerchantProductService {

    public void addMerchantProduct(MerchantProduct merchantProduct);

    public void deleteMerchantProduct(String id);

    public MerchantProduct getMerchantProduct(String id);

    public void updateMerchantProduct(MerchantProduct merchantProduct);

    public List<MerchantProduct> getMerchantFromProductId(String id);

   // public String getPriorityMerchantId(String id);

    public MerchantProduct getMerchantProduct(String productId,String merchantId);

    public int updateMerchantStock(String productId,String merchantId,int productCount);

    public int getProductQuantity(String productId,String merchantId);


    public int getStock(String productId,String merchantId);
}
