package com.services;

import com.domains.User;
import com.dtos.full_info.UserFullInfoDto;
import com.dtos.post.UserPostDto;

import java.util.List;

public interface UserService {
    void save(UserPostDto dto);
    void update(UserFullInfoDto dto);
    UserFullInfoDto findById(int id);
    void deleteById(int id);
    User findByEmail(String email);
    List<UserFullInfoDto> findAll();
}
