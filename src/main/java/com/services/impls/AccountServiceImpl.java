package com.services.impls;

import com.BusinessMapper;
import com.domains.Account;
import com.dtos.full_info.AccountFullInfoDto;
import com.dtos.post.AccountPostDto;
import com.repositories.AccountRepository;
import com.services.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountRepository repo;
    @Resource
    private BusinessMapper bm;

    @Override
    public void save(AccountPostDto dto) {
        repo.save(bm.AccountPostDtoToAccount(dto));
    }

    @Override
    public void update(AccountFullInfoDto dto) {
        Account account = repo.findById(dto.getId()).get();

        account.setMoney(dto.getMoney());
        account.setUser(bm.UserFromUserFullInfo(dto.getUser()));

        repo.save(account);
    }

    @Override
    public AccountFullInfoDto findById(int id) {
        return bm.AccountToAccountFullDto(repo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
