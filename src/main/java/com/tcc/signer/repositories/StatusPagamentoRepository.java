package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.StatusPagamento;

@Repository
public interface StatusPagamentoRepository extends JpaRepository<StatusPagamento, Integer> {

}
