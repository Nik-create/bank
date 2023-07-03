package com.domains;

import com.domains.enums.Instrument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MyAgreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Instrument instrument;
    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;
    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;
    private LocalDate dateAgreement;

    public static Agreement createAgreement(Order sell, Order buy){
        return new Agreement(null, sell.getInstrument(), sell.getTrader(), buy.getTrader(), LocalDate.now());
    }
}
