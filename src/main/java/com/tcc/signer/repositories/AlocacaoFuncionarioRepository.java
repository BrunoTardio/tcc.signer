package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.AlocacaoFuncionario;

@Repository
public interface AlocacaoFuncionarioRepository extends JpaRepository<AlocacaoFuncionario, Integer> {

}
