package com.pride.service.product;

import com.pride.domain.Product;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface ProductService {
    List<Product> viewAllProducts();

    Product selectProductById(String id);

    MyPageHelper<Product> viewPageProducts(Integer page, Integer rows);

}
