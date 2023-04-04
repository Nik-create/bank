package com;

import com.domains.Account;
import com.domains.Agreement;
import com.domains.Order;
import com.domains.User;
import com.domains.enums.Role;
import com.domains.enums.StatusOrder;
import com.dtos.full_info.AccountFullInfoDto;
import com.dtos.full_info.AgreementFullInfoDto;
import com.dtos.full_info.OrderFullInfoDto;
import com.dtos.full_info.UserFullInfoDto;
import com.dtos.post.AccountPostDto;
import com.dtos.post.AgreementPostDto;
import com.dtos.post.OrderPostDto;
import com.dtos.post.UserPostDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BusinessMapper {

    //User
    public User UserPostDtoToUser(UserPostDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRole(Role.USER);

        return user;
    }

    public User UserFromUserFullInfo(UserFullInfoDto dto){
        return new User(dto.getId(), dto.getRole(), dto.getEmail(), dto.getPassword(),
                dto.getFirstName(), dto.getLastName(), dto.getOrders(), dto.getSelled(), dto.getBuyed());
    }

    public UserFullInfoDto UserToUserFullInfo(User user){
        return new UserFullInfoDto(user.getId(), user.getRole(), user.getEmail(), user.getPassword(),
                user.getFirstName(), user.getLastName(), user.getOrders(), user.getSelled(), user.getBuyed());
    }

    //Order
    public Order OrderPostDtoToOrder(OrderPostDto dto){
        return new Order(0, StatusOrder.ACTIVE, dto.getOrderType(), dto.getPrice(), LocalDate.now(),
                dto.getInstrument(), null, UserFromUserFullInfo(dto.getTraderId()));
    }

    public Order OrderFullInfoDtoToOrder(OrderFullInfoDto dto){
        return new Order(dto.getId(), dto.getOrderStatus(), dto.getOrderType(), dto.getPrice(),
                dto.getDateCreate(), dto.getInstrument(), dto.getQuantity(),
                UserFromUserFullInfo(dto.getTraderId()));
    }

    public OrderFullInfoDto OrderToOrderFullDto(Order order){
        return new OrderFullInfoDto(order.getId(), order.getOrderStatus(), order.getOrderType(), order.getPrice(),
                order.getDateCreate(), order.getInstrument(), order.getQuantity(),
                UserToUserFullInfo(order.getTraderId()));
    }

    //Account
    public Account AccountPostDtoToAccount(AccountPostDto dto){
        return new Account(0, dto.getMoney(), UserFromUserFullInfo(dto.getUser()));
    }

    public Account AccountFullDtoToAccount(AccountFullInfoDto dto){
        return new Account(dto.getId(), dto.getMoney(), UserFromUserFullInfo(dto.getUser()));
    }

    public AccountFullInfoDto AccountToAccountFullDto(Account account){
        return new AccountFullInfoDto(account.getId(), account.getMoney(), UserToUserFullInfo(account.getUser()));
    }

    //Agreement
    public Agreement AgreementFullDtoToAgreement(AgreementFullInfoDto dto){
        return new Agreement(dto.getId(), dto.getInstrument(), UserFromUserFullInfo(dto.getSeller()),
                UserFromUserFullInfo(dto.getBuyer()), dto.getDateAgreement());
    }

    public AgreementFullInfoDto AgreementToAgreementFullDto(Agreement agreement){
        return new AgreementFullInfoDto(agreement.getId(), agreement.getInstrument(),
                UserToUserFullInfo(agreement.getSeller()),
                UserToUserFullInfo(agreement.getBuyer()), agreement.getDateAgreement());
    }

    public Agreement AgreementPostDtoToAgreement(AgreementPostDto dto){
        return new Agreement(0, dto.getInstrument(), UserFromUserFullInfo(dto.getSeller()),
                UserFromUserFullInfo(dto.getBuyer()), dto.getDateAgreement());
    }
}
