package com.example.MerchantMicroService.service;

import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);


    }

    @Override
    public void deleteMerchant(String id) {

        merchantRepository.delete(id);
    }

    @Override
    public Merchant getMerchant(String id) {
        return merchantRepository.findOne(id);
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }


}
