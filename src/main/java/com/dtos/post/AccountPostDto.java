package com.dtos.post;

import com.dtos.full_info.UserFullInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountPostDto {
    private BigDecimal money;
    private UserFullInfoDto user;
}
