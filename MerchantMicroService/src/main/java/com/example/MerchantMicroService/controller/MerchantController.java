package com.example.MerchantMicroService.controller;

import com.example.MerchantMicroService.dto.MerchantDTO;
import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantHelper;

    @PostMapping("/addMerchant")
    public void addMerchant(@RequestBody MerchantDTO merchantDTO)
    {

        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO, merchant);
        merchantHelper.addMerchant(merchant);
    }



    @RequestMapping("/selectMerchant/{id}")
    public MerchantDTO getMerchant(@PathVariable String id)
    {

        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchantHelper.getMerchant(id),merchantDTO);
        return merchantDTO;

    }

    @RequestMapping(value = "/updateMerchant", method = RequestMethod.PUT)
    public void updateMerchant(@RequestBody MerchantDTO merchantDTO)
    {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO, merchant);
        merchantHelper.updateMerchant(merchant);
    }


    @RequestMapping(value = "/deleteMerchant/{id}",method = RequestMethod.DELETE)
    public void  deleteMerchant(@PathVariable String id)
    {
        merchantHelper.deleteMerchant(id);

    }



}
