package com.services.impls;

import com.BusinessMapper;
import com.domains.Agreement;
import com.dtos.full_info.AgreementFullInfoDto;
import com.dtos.post.AgreementPostDto;
import com.repositories.AgreementRepository;
import com.repositories.UserRepository;
import com.services.AgreementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AgreementServiceImpl implements AgreementService {
    @Resource
    private AgreementRepository repo;
    @Resource
    private BusinessMapper bm;

    @Override
    public void save(AgreementPostDto dto) {
        repo.save(bm.AgreementPostDtoToAgreement(dto));
    }

    @Override
    public void update(AgreementFullInfoDto dto) {
        Agreement agreement = repo.findById(dto.getId()).get();

        agreement.setBuyer(bm.UserFromUserFullInfo(dto.getBuyer()));
        agreement.setDateAgreement(dto.getDateAgreement());
        agreement.setInstrument(dto.getInstrument());
        agreement.setSeller(bm.UserFromUserFullInfo(dto.getSeller()));

        repo.save(agreement);
    }

    @Override
    public AgreementFullInfoDto findById(int id) {
        return bm.AgreementToAgreementFullDto(repo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
