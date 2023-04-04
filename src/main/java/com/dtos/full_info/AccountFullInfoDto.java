package com.dtos.full_info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountFullInfoDto {
    private Integer id;
    private BigDecimal money;
    private UserFullInfoDto user;
}
