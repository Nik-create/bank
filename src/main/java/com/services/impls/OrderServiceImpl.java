package com.services.impls;

import com.BusinessMapper;
import com.domains.Order;
import com.dtos.full_info.OrderFullInfoDto;
import com.dtos.post.OrderPostDto;
import com.repositories.OrderRepository;
import com.services.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository repo;
    @Resource
    private BusinessMapper bm;

    @Override
    public Order save(OrderPostDto dto) {
        return repo.save(bm.OrderPostDtoToOrder(dto));
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
        order.setTrader(bm.UserFromUserFullInfo(dto.getTraderId()));

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

    @Override
    public List<OrderFullInfoDto> findAll() {
        List<Order> all = repo.findAll();
        List<OrderFullInfoDto> dtos = new ArrayList<>();

        for(Order r : all){
           dtos.add(bm.OrderToOrderFullDto(r));
        }

        return dtos;
    }

    @Override
    public List<OrderFullInfoDto> findAllByTraderEmail(String email) {
        List<Order> orders = repo.findAllByTraderEmail(email);
        List<OrderFullInfoDto> dtos = new ArrayList<>();
        for(Order r: orders) {
            dtos.add(bm.OrderToOrderFullDto(r));
        }
        return dtos;
    }
}
