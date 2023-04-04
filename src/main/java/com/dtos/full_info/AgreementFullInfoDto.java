package com.dtos.full_info;

import com.domains.enums.Instrument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgreementFullInfoDto {
    private Integer id;
    private Instrument instrument;
    private UserFullInfoDto seller;
    private UserFullInfoDto buyer;
    private LocalDate dateAgreement;
}
