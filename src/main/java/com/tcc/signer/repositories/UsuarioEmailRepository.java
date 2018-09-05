package com.tcc.signer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.signer.domain.UsuarioEmail;
@Repository
public interface UsuarioEmailRepository extends JpaRepository<UsuarioEmail, Integer> {

}
