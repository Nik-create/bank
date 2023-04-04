package com.services.impls;

import com.BusinessMapper;
import com.domains.User;
import com.dtos.full_info.UserFullInfoDto;
import com.dtos.post.UserPostDto;
import com.repositories.UserRepository;
import com.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository repo;
    @Resource
    private BusinessMapper bm;

    private final PasswordEncoder encoder;

    public UserServiceImpl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void save(UserPostDto dto) {
        User s = bm.UserPostDtoToUser(dto);

        s.setPassword(encoder.encode(s.getPassword()));
        repo.save(s);
    }

    @Override
    public void update(UserFullInfoDto dto) {
        User user = repo.findById(dto.getId()).get();

        encoder.encode(dto.getPassword());

        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setBuyed(dto.getBuyed());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setOrders(dto.getOrders());
        user.setSelled(dto.getSelled());

        repo.save(user);
    }

    @Override
    public UserFullInfoDto findById(int id) {
        return bm.UserToUserFullInfo(repo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> optional = repo.findAll().stream().filter(user -> user.getEmail().equals(email)).findFirst();
        return optional.orElse(null);
    }
}
