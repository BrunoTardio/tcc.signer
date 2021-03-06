package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.StatusPedido;

@Repository
public interface StatusPedidoRepository extends JpaRepository<StatusPedido, Integer> {

}
