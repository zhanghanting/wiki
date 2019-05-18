package com.pride.service.product;

import com.pride.domain.Product;
import com.pride.domain.ProductExample;
import com.pride.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> viewAllProducts() {
        return productMapper.selectByExample(new ProductExample());
    }
}
