package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.controller.MerchantProductController;
import com.example.MerchantMicroService.dto.MerchantDTO;
import com.example.MerchantMicroService.entity.MerchantProduct;
import com.example.MerchantMicroService.repository.MerchantProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantProductServiceImpl implements MerchantProductService {

    @Autowired
    private MerchantProductRepository merchantProductRepository;


    @Override
    public void addMerchantProduct(MerchantProduct merchantProduct) {
        merchantProductRepository.save(merchantProduct);

    }

    @Override
    public void deleteMerchantProduct(String id) {

        merchantProductRepository.delete(id);

    }

    @Override
    public MerchantProduct getMerchantProduct(String id) {

        return merchantProductRepository.findOne(id);
    }

    @Override
    public void updateMerchantProduct(MerchantProduct merchantProduct) {
        merchantProductRepository.save(merchantProduct);
    }

    @Override
    public List<MerchantProduct> getMerchantFromProductId(String id) {
        return merchantProductRepository.getMerchantFromProductId(id);

    }

    @Override
    public MerchantProduct getMerchantProduct(String productId, String merchantId) {
        return merchantProductRepository.getMerchantProduct(productId,merchantId);
    }

    @Override
    public int updateMerchantStock(String productId, String merchantId, int productCount) {
        return merchantProductRepository.updateMerchantStock(productId,merchantId,productCount);

    }

    @Override
    public int getProductQuantity(String productId, String merchantId) {
        return merchantProductRepository.getProductQuantity(productId,merchantId);
    }

    @Override
    public int getStock(String productId, String merchantId) {
        return merchantProductRepository.getStock(productId,merchantId);
    }
//
//    @Override
//    public String getPriorityMerchantId(String id) {
//        return merchantProductRepository.getPriorityMerchantId(id);
//    }


}
