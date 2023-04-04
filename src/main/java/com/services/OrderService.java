package com.services;

import com.dtos.full_info.OrderFullInfoDto;
import com.dtos.post.OrderPostDto;

public interface OrderService {
    void save(OrderPostDto dto);
    void update(OrderFullInfoDto dto);
    OrderFullInfoDto findById(int id);
    void deleteById(int id);
}
