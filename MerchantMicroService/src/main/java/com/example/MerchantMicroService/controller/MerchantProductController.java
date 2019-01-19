package com.example.MerchantMicroService.controller;

import com.example.MerchantMicroService.dto.MerchantDTO;
import com.example.MerchantMicroService.dto.MerchantProductDTO;
import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.entity.MerchantProduct;
import com.example.MerchantMicroService.service.MerchantProductService;
import com.example.MerchantMicroService.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchantProductController {

    @Autowired
    MerchantProductService merchantProductHelper;

    @PostMapping("/addMerchantProduct")
    public void addMerchantProduct(@RequestBody MerchantProductDTO merchantProductDTO)
    {

        MerchantProduct merchantProduct=new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO, merchantProduct);
        merchantProductHelper.addMerchantProduct(merchantProduct);
    }



    @RequestMapping("/selectMerchantProduct/{id}")
    public MerchantProductDTO getMerchantProduct(@PathVariable String id)
    {

        MerchantProductDTO merchantProductDTO=new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductHelper.getMerchantProduct(id),merchantProductDTO);
        return merchantProductDTO;

    }

    @RequestMapping(value = "/updateMerchantProduct", method = RequestMethod.PUT)
    public void updateMerchantProduct(@RequestBody MerchantProductDTO merchantProductDTO)
    {
        MerchantProduct merchantProduct=new MerchantProduct();
        BeanUtils.copyProperties(merchantProductDTO, merchantProduct);
        merchantProductHelper.updateMerchantProduct(merchantProduct);
    }


    @RequestMapping(value = "/deleteMerchantProduct/{id}",method = RequestMethod.DELETE)
    public void  deleteMerchantProduct(@PathVariable String id)
    {
        merchantProductHelper.deleteMerchantProduct(id);

    }


}
