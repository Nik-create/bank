package com.dtos.post;

import com.domains.enums.Instrument;
import com.domains.enums.TypeOrder;
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
public class OrderPostDto {
    private TypeOrder orderType;
    private BigDecimal price;
    private Instrument instrument;
    private UserFullInfoDto traderId;
}
