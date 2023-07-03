package com.services;

import com.dtos.full_info.AgreementFullInfoDto;
import com.dtos.post.AgreementPostDto;

import java.util.List;

public interface AgreementService {
    void save(AgreementPostDto dto);
    void update(AgreementFullInfoDto dto);
    AgreementFullInfoDto findById(int id);
    void deleteById(int id);
    List<AgreementFullInfoDto> findAllBySellerEmail(String email);
}
