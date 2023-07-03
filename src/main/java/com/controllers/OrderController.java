package com.controllers;

import com.BusinessMapper;
import com.domains.Order;
import com.domains.User;
import com.domains.enums.Instrument;
import com.domains.enums.TypeOrder;
import com.dtos.post.OrderPostDto;
import com.services.OrderService;
import com.services.UserService;
import com.services.impls.TradeSessionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrderService service;
    @Resource
    private UserService userService;
    @Resource
    BusinessMapper bm;
    @Resource
    private TradeSessionServiceImpl serviceSession;

    @GetMapping("/form-order")
    public String formOrderCreate(Model model) {
        model.addAttribute("order", new OrderPostDto());
        model.addAttribute("orderTypes", TypeOrder.values());
        model.addAttribute("instruments", Instrument.values());

        return "order-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("order") OrderPostDto order, Principal principal){
        User user = userService.findByEmail(principal.getName());
        order.setTrader(bm.UserToUserFullInfo(user));
        Order save = service.save(order);

        if(save.getOrderType() == TypeOrder.BUY){
            serviceSession.getSESSION().getOrdersBuy().add(save);
        }else if(order.getOrderType() == TypeOrder.SELL){
            serviceSession.getSESSION().getOrdersSell().add(save);
        }

        return "redirect:/home";
    }

    @GetMapping("/myOrders")
    public String myOrders(Model model, Principal pr){
        model.addAttribute("orders", service.findAllByTraderEmail(pr.getName()));
        return "my-orders";
    }

    @GetMapping("/all")
    public String allOrders(Model model){
        model.addAttribute("allOrder", service.findAll());
        return "orders";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/orders/myOrders";
    }
}
