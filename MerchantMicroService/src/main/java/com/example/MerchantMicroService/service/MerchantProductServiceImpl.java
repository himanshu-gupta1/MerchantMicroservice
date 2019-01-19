package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.controller.MerchantProductController;
import com.example.MerchantMicroService.entity.MerchantProduct;
import com.example.MerchantMicroService.repository.MerchantProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
