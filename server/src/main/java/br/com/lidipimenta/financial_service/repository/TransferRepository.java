package br.com.lidipimenta.financial_service.repository;

import br.com.lidipimenta.financial_service.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}