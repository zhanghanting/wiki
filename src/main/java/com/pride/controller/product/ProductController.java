package com.pride.controller.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Product;
import com.pride.service.product.ProductService;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/erp/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    // 返回product主页面
    @RequestMapping("find")
    public String find(){
        return "product_list";
    }
    // 返回分页的Product的List
    // json
    @ResponseBody
    @RequestMapping("list")
    public MyPageHelper<Product> list(Integer page,Integer rows){
        return productService.viewPageProducts(page,rows);
    }


    // 通过id修改product
    // json
    @ResponseBody
    @RequestMapping("get/{id}")
    public Product getCustom(@PathVariable String id){
        return productService.selectProductById(id);
    }


    // 获取Product的所有数据
    // json
    @ResponseBody
    @RequestMapping("get_data")
    public List<Product> getData(){
        return productService.viewAllProducts();
    }


    // 返回product的添加页面
    @RequestMapping("add")
    public String addJudge(){
        return "product_add";
    }
    // 通过id
}
