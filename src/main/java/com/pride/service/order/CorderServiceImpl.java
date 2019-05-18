package com.pride.service.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pride.domain.Corder;
import com.pride.domain.CorderExample;
import com.pride.domain.Task;
import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.mapper.CorderMapper;
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

    @ResponseBody
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
    @ResponseBody
    public TypeCode updateCorderByModel(Corder corder) {
        TypeCode typeCode = new TypeCode("200","OK");

        try {
            corderMapper.updateByPrimaryKey(corder);
        }catch (Exception e){
            typeCode.setMsg("ERROR");
        }
        return typeCode;
    }

    @ResponseBody
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


}
