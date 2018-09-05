package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.ProdutoValidade;

@Repository
public interface ProdutoValidadeRepository extends JpaRepository<ProdutoValidade, Integer>{

}
