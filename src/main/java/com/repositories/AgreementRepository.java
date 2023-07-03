package com.repositories;

import com.domains.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
    List<Agreement> findAllBySellerEmail(String email);
}
