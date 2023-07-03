package com.services.impls;

import com.BusinessMapper;
import com.domains.User;
import com.dtos.full_info.UserFullInfoDto;
import com.dtos.post.UserPostDto;
import com.repositories.UserRepository;
import com.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final BusinessMapper bm;
    private final PasswordEncoder encoder;

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

    @Override
    public List<UserFullInfoDto> findAll() {
        List<User> all = repo.findAll();
        List<UserFullInfoDto> dtos = new ArrayList<>();
        for(User u: all){
            dtos.add(bm.UserToUserFullInfo(u));
        }
        return dtos;
    }
}
