package com.example.MerchantMicroService.controller;

import com.example.MerchantMicroService.Quote;
import com.example.MerchantMicroService.dto.MerchantDTO;
import com.example.MerchantMicroService.dto.MerchantProductDTO;
import com.example.MerchantMicroService.dto.NeededDTO;
import com.example.MerchantMicroService.entity.Merchant;
import com.example.MerchantMicroService.entity.MerchantProduct;
import com.example.MerchantMicroService.entity.Order;
import com.example.MerchantMicroService.service.MerchantProductService;
import com.example.MerchantMicroService.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MerchantProductController {

    @Autowired
    MerchantProductService merchantProductHelper;

    @Autowired
    MerchantService merchantHelper;

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


    @RequestMapping(value = "/getMerchantFromProductId/{id}",method = RequestMethod.GET)
    public List<MerchantProductDTO> getMerchantFromProductId(@PathVariable String id)
    {

        List<MerchantProductDTO> merchantProductDTOS=new ArrayList<>();

        List<MerchantProduct> merchantProducts=merchantProductHelper.getMerchantFromProductId(id);
        System.out.println(merchantProducts);

        for(MerchantProduct merchantProduct:merchantProducts)
        {
            MerchantProductDTO merchantProductDTO=new MerchantProductDTO();
            BeanUtils.copyProperties(merchantProduct,merchantProductDTO);
            merchantProductDTOS.add(merchantProductDTO);
        }

        return merchantProductDTOS;

    }



    @RequestMapping(value = "/getPriorityMerchant/{id}",method = RequestMethod.GET)
    public MerchantProductDTO getPriorityMerchant(@PathVariable  String id)
    {

        List<MerchantProduct> merchantProducts=merchantProductHelper.getMerchantFromProductId(id);
        double maxRating= 0;
        MerchantProduct merchantProductHigh=new MerchantProduct();
        for(MerchantProduct merchantProduct:merchantProducts)
        {
            if(merchantProduct.getMerchant().getMerchantRating()>maxRating)
            {
                maxRating=merchantProduct.getMerchant().getMerchantRating();
                merchantProductHigh=merchantProduct;
            }
        }
        MerchantProductDTO merchantProductDTO=new MerchantProductDTO();
        BeanUtils.copyProperties(merchantProductHigh,merchantProductDTO);

        return merchantProductDTO;
    }



    @RequestMapping(value = "/getMerchantProduct/{productId}/{merchantId}",method = RequestMethod.GET)
    public MerchantProduct getMerchantProduct(@PathVariable String productId,@PathVariable String merchantId) {
        return merchantProductHelper.getMerchantProduct(productId,merchantId);
    }


    @Transactional
    @RequestMapping(value = "/updateMerchantStock/{productId}/{merchantId}/{pcnt}",method = RequestMethod.POST)
    public int updateMerchantStock(@PathVariable String productId,@PathVariable String merchantId,@PathVariable String pcnt) {
        int pc=Integer.parseInt(pcnt);
        RestTemplate restTemplate=new RestTemplate();
        int qty=merchantProductHelper.getProductQuantity(productId,merchantId);
        return  merchantProductHelper.updateMerchantStock(productId,merchantId,qty-pc);
    }



    @RequestMapping(value = "/validateOrder",method = RequestMethod.POST)
    public String validateOrder(@RequestBody List<Order> orders) {

        System.out.println(orders);

        String response="true";

        for(Order order:orders)
        {
            int stock=merchantProductHelper.getStock(order.getProductId(),order.getMerchantId());
            if(order.getPcnt()>stock) {
                response = "false";
                break;

            }
        }

        if(response.equals("true"))
        {

            for(Order order:orders)
            {
                int qty=merchantProductHelper.getProductQuantity(order.getProductId(),order.getMerchantId());
                merchantProductHelper.updateMerchantStock(order.getProductId(),order.getMerchantId(),qty-order.getPcnt());
            }
        }
        return response;

    }







}
