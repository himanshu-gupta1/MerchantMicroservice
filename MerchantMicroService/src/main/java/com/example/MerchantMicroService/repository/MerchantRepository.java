package com.example.MerchantMicroService.repository;

import com.example.MerchantMicroService.entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,String> {


}
