package com.pride.controller.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Product;
import com.pride.service.product.ProductService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/product/")
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("find")
    public String find(){
        return "product_list";
    }


    // 返回分页的Product的List
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<Product> list(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<Product> products = productService.viewAllProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        MyPageHelper<Product> pageHelper = new MyPageHelper<>();
        pageHelper.setRows(products);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }

}
