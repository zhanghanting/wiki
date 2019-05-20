package com.pride.service.product;

import com.pride.domain.Product;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;

import java.util.List;

public interface ProductService {
    List<Product> viewAllProducts();

    Product selectProductById(String id);

    MyPageHelper<Product> viewPageProducts(Integer page, Integer rows);

    TypeCode insertProduct(Product product);

    TypeCode updateByModel(Product product);

    TypeCode deleteProductsByIds(String[] ids);

    MyPageHelper<Product> searchProductByProductId(String searchValue, Integer page, Integer rows);

    MyPageHelper<Product> searchProductByProductName(String searchValue, Integer page, Integer rows);

    MyPageHelper<Product> searchProductByProductType(String searchValue, Integer page, Integer rows);
}
