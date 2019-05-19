package com.pride.domain.order;


import com.pride.domain.Corder;
import com.pride.domain.Custom;
import com.pride.domain.Product;

import java.math.BigDecimal;
import java.util.Date;

//订单管理页面所有属性
public class OrderPageType extends Corder {

    private Custom custom;

    private Product product;

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public  void buildCorder(Corder corder){
        this.setOrderId(corder.getOrderId());
        this.setCustomId(corder.getCustomId());
        this.setProductId(corder.getProductId());
        this.setOrderDate(corder.getOrderDate());
        this.setRequestDate(corder.getRequestDate());
        this.setNote(corder.getNote());
        this.setQuantity(corder.getQuantity());
        this.setUnitPrice(corder.getUnitPrice());
        this.setUnit(corder.getUnit());
        this.setImage(corder.getImage());
        this.setFile(corder.getFile());
        this.setStatus(corder.getStatus());
    }
}
