package com.example.MerchantMicroService.repository;

import com.example.MerchantMicroService.entity.MerchantProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MerchantProductRepository extends CrudRepository<MerchantProduct,String> {


    //SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)

    @Query(value = "SELECT * FROM merchant_product WHERE product_id=?1",nativeQuery = true)
    public List<MerchantProduct> getMerchantFromProductId(String productId);



    @Query(value = "SELECT * FROM merchant_product WHERE product_id=?1 and merchant_id=?2",nativeQuery = true)
    public MerchantProduct getMerchantProduct(String productId,String merchantId);


//    @Query(value = "SELECT * FROM merchant_product WHERE product_id=?1 and merchant_id=?2",nativeQuery = true)
//    public MerchantProduct getMerchantProduct(String productId,String merchantId);






    @Query(value = "SELECT stock FROM merchant_product WHERE product_id=?1 and merchant_id=?2",nativeQuery = true)
    public int getProductQuantity(String productId,String merchantId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE merchant_product SET stock = ?3 WHERE product_id=?1 and merchant_id=?2",nativeQuery = true)
    public int updateMerchantStock(String productId,String merchantId,int productCount);



    @Query(value = "SELECT stock from merchant_product WHERE product_id=?1 and merchant_id=?2",nativeQuery = true)
    public int getStock(String productId,String merchantId);










    //public List<MerchantProduct> findByProductId(String productId);








//    @Query(value = "SELECT p.merchant_id FROM merchant_product p Inner Join merchant m ON p.merchant_id=p.merchant_id WHERE p.product_id=?1 ORDER BY m.merchant_rating DESC LIMIT 1",nativeQuery = true)
//    public String getPriorityMerchantId(String id);

















}
