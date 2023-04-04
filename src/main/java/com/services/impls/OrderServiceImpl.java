package com.services.impls;

import com.BusinessMapper;
import com.domains.Order;
import com.dtos.full_info.OrderFullInfoDto;
import com.dtos.post.OrderPostDto;
import com.repositories.OrderRepository;
import com.services.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository repo;
    @Resource
    private BusinessMapper bm;

    @Override
    public void save(OrderPostDto dto) {
        repo.save(bm.OrderPostDtoToOrder(dto));
    }

    @Override
    public void update(OrderFullInfoDto dto) {
        Order order = repo.findById(dto.getId()).get();

        order.setDateCreate(dto.getDateCreate());
        order.setInstrument(dto.getInstrument());
        order.setOrderStatus(dto.getOrderStatus());
        order.setOrderType(dto.getOrderType());
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());
        order.setTraderId(bm.UserFromUserFullInfo(dto.getTraderId()));

        repo.save(order);
    }

    @Override
    public OrderFullInfoDto findById(int id) {
        return bm.OrderToOrderFullDto(repo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
