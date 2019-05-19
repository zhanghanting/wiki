package com.pride.service.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.*;
import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.CorderMapper;
import com.pride.mapper.CustomMapper;
import com.pride.mapper.ProductMapper;
import com.pride.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CorderServiceImpl implements CorderService{

    @Autowired
    CorderMapper corderMapper;
    @Autowired
    CustomMapper customMapper;
    @Autowired
    ProductMapper productMapper;


    @Override
    public MyPageHelper<OrderPageType> viewAllOrders(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<OrderPageType> corders = corderMapper.viewAllOrders();
        PageInfo<OrderPageType> pageInfo = new PageInfo<>(corders);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setRows(corders);
        pageHelper.setTotal(pageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public TypeCode updateCorderByModel(Corder corder) {
        TypeCode typeCode = new TypeCode("200","OK");

        try {
            corderMapper.updateByPrimaryKey(corder);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }


    @Override
    public TypeCode deleteCordersByIds(String[] ids) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            for (String id : ids) {
                corderMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }

        return typeCode;
    }

    @Override
    public TypeCode insertOrder(Corder corder) {
        TypeCode typeCode = new TypeCode("200","OK");
        try {
            corderMapper.insert(corder);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @Override
    public MyPageHelper<OrderPageType> searchOrderByOrderId(String searchValue, Integer page, Integer rows) {
        CorderExample corderExample = new CorderExample();
        CorderExample.Criteria criteria = corderExample.createCriteria();
        criteria.andOrderIdLike("%" + searchValue + "%");
        PageHelper.startPage(page,rows);
        List<OrderPageType> orderPageTypes = this.viewSearchPage(corderExample);
        PageInfo<OrderPageType> pageInfo = new PageInfo<>(orderPageTypes);
        MyPageHelper<OrderPageType> myPageHelper = new MyPageHelper<>();
        myPageHelper.setRows(orderPageTypes);
        myPageHelper.setTotal(pageInfo.getTotal());
        return myPageHelper;
    }

    @Override
    public MyPageHelper<OrderPageType> searchOrderByOrderorderCustomName(String searchValue, Integer page, Integer rows) {
        searchValue = "'" + "%" + searchValue + "%" + "'";
        PageHelper.startPage(page,rows);
        List<OrderPageType> orderPageTypes = corderMapper.selectOrderPageTypeByCustomName(searchValue);
        PageInfo<OrderPageType> pageInfo = new PageInfo<>(orderPageTypes);
        MyPageHelper<OrderPageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(orderPageTypes);
        return pageHelper;


    }

    @Override
    public MyPageHelper<OrderPageType> searchOrderByOrderProductName(String searchValue, Integer page, Integer rows) {
        searchValue = "'" + "%" + searchValue + "%" + "'";
        PageHelper.startPage(page,rows);
        List<OrderPageType> orderPageTypes = corderMapper.selectOrderPageTypeByProductName(searchValue);
        System.out.println(orderPageTypes);
        PageInfo<OrderPageType> pageInfo = new PageInfo<>(orderPageTypes);
        MyPageHelper<OrderPageType> pageHelper = new MyPageHelper<>();
        pageHelper.setTotal(pageInfo.getTotal());
        pageHelper.setRows(orderPageTypes);
        return pageHelper;
    }

    @Override
    public List<Corder> viewAllCorders() {
        return corderMapper.selectByExample(new CorderExample());
    }


    private List<OrderPageType> viewSearchPage(CorderExample corderExample){
        List<Corder> orders = corderMapper.selectByExample(corderExample);
        List<OrderPageType> orderPageTypes = new ArrayList<>();
        for (Corder corder : orders) {
            OrderPageType orderPageType = new OrderPageType();
            orderPageType.buildCorder(corder);
            orderPageType.setProduct(productMapper.selectByPrimaryKey(corder.getProductId()));
            orderPageType.setCustom(customMapper.selectByPrimaryKey(corder.getCustomId()));
            orderPageTypes.add(orderPageType);
        }
        return orderPageTypes;
    }


}
