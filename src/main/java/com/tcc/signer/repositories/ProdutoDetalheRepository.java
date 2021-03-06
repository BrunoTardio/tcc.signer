package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.ProdutoDetalhe;

@Repository
public interface ProdutoDetalheRepository extends JpaRepository<ProdutoDetalhe, Integer> {

}
