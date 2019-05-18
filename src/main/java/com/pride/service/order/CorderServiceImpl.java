package com.pride.service.order;

import com.pride.domain.Corder;
import com.pride.domain.CorderExample;
import com.pride.domain.order.OrderPageType;
import com.pride.mapper.CorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderServiceImpl implements CorderService{

    @Autowired
    CorderMapper corderMapper;

    @Override
    public List<OrderPageType> viewAllOrders() {
        return corderMapper.viewAllOrders();
    }
}
