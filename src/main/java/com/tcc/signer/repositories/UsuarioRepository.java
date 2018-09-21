package com.tcc.signer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.signer.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	// exemplo de tratamento de duplicidade LOGIN  -
	// ref-= https://www.udemy.com/spring-boot-ionic/learn/v4/t/lecture/8203104?start=15
	@Transactional(readOnly = true)
	Usuario findByLogin(String login);

}
