package com.services;

import com.domains.Order;
import com.dtos.full_info.OrderFullInfoDto;
import com.dtos.post.OrderPostDto;

import java.util.List;

public interface OrderService {
    Order save(OrderPostDto dto);
    void update(OrderFullInfoDto dto);
    OrderFullInfoDto findById(int id);
    void deleteById(int id);
    List<OrderFullInfoDto> findAllByTraderEmail(String email);
    List<OrderFullInfoDto> findAll();
}
