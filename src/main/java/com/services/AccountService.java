package com.services;

import com.dtos.full_info.AccountFullInfoDto;
import com.dtos.post.AccountPostDto;

public interface AccountService {
    void save(AccountPostDto dto);
    void update(AccountFullInfoDto dto);
    AccountFullInfoDto findById(int id);
    void deleteById(int id);
}
