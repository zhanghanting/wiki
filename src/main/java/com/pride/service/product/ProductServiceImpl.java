package com.pride.service.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Product;
import com.pride.domain.ProductExample;
import com.pride.mapper.ProductMapper;
import com.pride.utils.MyPageHelper;
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

    @Override
    public Product selectProductById(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public MyPageHelper<Product> viewPageProducts(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(new ProductExample());
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        MyPageHelper<Product> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(products);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
