package com.pride.controller.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Product;
import com.pride.domain.typecode.TypeCode;
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
    //通过id查找product
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
    // 通过productId模糊查询
    @ResponseBody
    @RequestMapping("search_product_by_productId")
    public MyPageHelper<Product> searchProductByProductId(String searchValue,Integer page,Integer rows){
        return productService.searchProductByProductId(searchValue,page,rows);
    }
    // 通过productNam模糊查询
    @ResponseBody
    @RequestMapping("search_product_by_productName")
    public MyPageHelper<Product> searchProductByProductName(String searchValue,Integer page,Integer rows){
        return productService.searchProductByProductName(searchValue,page,rows);
    }
    // 通过productType模糊查询
    @ResponseBody
    @RequestMapping("search_product_by_productType")
    public MyPageHelper<Product> searchProductByProductType(String searchValue,Integer page,Integer rows){
        return productService.searchProductByProductType(searchValue,page,rows);
    }



    // 返回空的json
    @ResponseBody
    @RequestMapping("edit_judge")
    public String editJudge(){
        return null;
    }
    // 跳转到product的修改页面
    // json
    @RequestMapping("edit")
    public String edit(){
        return "product_edit";
    }
    // 通过id修改product
    @ResponseBody
    @RequestMapping("update_all")
    public TypeCode updateAll(Product product){
        return productService.updateByModel(product);
    }



    // 删除请求
    @ResponseBody
    @RequestMapping("delete_judge")
    public String deleteJudge(){
        return null;
    }
    // 通过id的Sring数组删除订单Corder
    @ResponseBody
    @RequestMapping("delete_batch")
    public TypeCode deleteBatch(String[] ids){
        return productService.deleteProductsByIds(ids);
    }






    // 返回空的json字符串
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return null;
    }
    // 返回product的添加页面
    @RequestMapping("add")
    public String add(){
        return "product_add";
    }
    // 通过id新增一个product实例
    @ResponseBody
    @RequestMapping("insert")
    public TypeCode insert(Product product){
        return productService.insertProduct(product);
    }
}
