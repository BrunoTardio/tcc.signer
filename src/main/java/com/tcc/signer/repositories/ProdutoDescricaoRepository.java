package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.ProdutoDescricao;

@Repository
public interface ProdutoDescricaoRepository extends JpaRepository<ProdutoDescricao, Integer> {

}
