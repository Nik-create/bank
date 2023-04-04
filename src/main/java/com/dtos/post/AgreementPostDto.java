package com.dtos.post;

import com.domains.enums.Instrument;
import com.dtos.full_info.UserFullInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgreementPostDto {
    private Instrument instrument;
    private UserFullInfoDto seller;
    private UserFullInfoDto buyer;
    private LocalDate dateAgreement;
}
