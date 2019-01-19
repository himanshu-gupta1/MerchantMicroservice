package com.example.MerchantMicroService.repository;

import com.example.MerchantMicroService.entity.MerchantProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantProductRepository extends CrudRepository<MerchantProduct,String> {


}
