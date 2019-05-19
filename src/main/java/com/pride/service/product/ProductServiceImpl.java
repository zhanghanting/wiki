package com.pride.service.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Product;
import com.pride.domain.ProductExample;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.ProductMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Override
    public TypeCode insertProduct(Product product) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            productMapper.insert(product);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;

    }

    @Override
    public TypeCode updateByModel(Product product) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            productMapper.updateByPrimaryKey(product);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
            typeCode.setStatus("500");
        }
        return typeCode;
    }

    @ResponseBody
    @Override
    public TypeCode deleteProductsByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                productMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }

        return typeCode;
    }

    @Override
    public MyPageHelper<Product> searchProductByProductId(String searchValue, Integer page, Integer rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdLike("%" + searchValue + "%");
        return viewSearch(productExample,page,rows);
    }

    @Override
    public MyPageHelper<Product> searchProductByProductName(String searchValue, Integer page, Integer rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" + searchValue + "%");
        return viewSearch(productExample,page,rows);
    }

    @Override
    public MyPageHelper<Product> searchProductByProductType(String searchValue, Integer page, Integer rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductTypeLike("%" + searchValue + "%");
        return viewSearch(productExample,page,rows);
    }


    private MyPageHelper<Product> viewSearch(ProductExample customExample,Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(customExample);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        MyPageHelper<Product> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(products);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }
}
