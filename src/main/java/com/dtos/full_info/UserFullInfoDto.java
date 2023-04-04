package com.dtos.full_info;

import com.domains.Agreement;
import com.domains.Order;
import com.domains.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFullInfoDto {
    private Integer id;
    private Role role;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<Order> orders;
    private List<Agreement> selled;
    private List<Agreement> buyed;
}
