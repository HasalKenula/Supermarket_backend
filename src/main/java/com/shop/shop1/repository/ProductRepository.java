package com.shop.shop1.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.shop1.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    

}
