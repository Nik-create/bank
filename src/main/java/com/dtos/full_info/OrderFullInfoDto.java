package com.dtos.full_info;

import com.domains.enums.Instrument;
import com.domains.enums.StatusOrder;
import com.domains.enums.TypeOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderFullInfoDto {
    private Integer id;
    private StatusOrder orderStatus;
    private TypeOrder orderType;
    private BigDecimal price;
    private LocalDate dateCreate;
    private Instrument instrument;
    private Double quantity;
    private UserFullInfoDto traderId;
}
