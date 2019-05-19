package com.pride.service.order;

import com.pride.domain.Corder;
import com.pride.domain.order.OrderPageType;
import com.pride.domain.typecode.TypeCode;
import com.pride.utils.MyPageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CorderService {
    MyPageHelper<OrderPageType> viewAllOrders(Integer page, Integer rows);

    TypeCode updateCorderByModel(Corder corder);

    TypeCode deleteCordersByIds(String[] ids);

    TypeCode insertOrder(Corder corder);

    MyPageHelper<OrderPageType> searchOrderByOrderId(String searchValue, Integer page, Integer rows);

    MyPageHelper<OrderPageType> searchOrderByOrderorderCustomName(String searchValue, Integer page, Integer rows);

    MyPageHelper<OrderPageType> searchOrderByOrderProductName(String searchValue, Integer page, Integer rows);

    List<Corder> viewAllCorders();

}