package com.pride.service.order;

import com.pride.domain.Corder;
import com.pride.domain.order.OrderPageType;

import java.util.List;

public interface CorderService {
    List<OrderPageType> viewAllOrders();
}
