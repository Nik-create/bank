package com.services;

import com.dtos.full_info.AgreementFullInfoDto;
import com.dtos.post.AgreementPostDto;

public interface AgreementService {
    void save(AgreementPostDto dto);
    void update(AgreementFullInfoDto dto);
    AgreementFullInfoDto findById(int id);
    void deleteById(int id);
}
