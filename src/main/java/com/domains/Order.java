package com.domains;

import com.domains.enums.Instrument;
import com.domains.enums.StatusOrder;
import com.domains.enums.TypeOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MyOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private StatusOrder orderStatus;
    @Enumerated(value = EnumType.STRING)
    private TypeOrder orderType;
    private BigDecimal price;
    private LocalDate dateCreate;
    @Enumerated(value = EnumType.STRING)
    private Instrument instrument;
    private Double quantity;
    @ManyToOne
    @JoinColumn(name = "trader")
    private User trader;
}
