package com.tcc.signer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.Usuario;
import com.tcc.signer.repositories.UsuarioRepository;
import com.tcc.signer.security.UserSS;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = repo.findByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(user.getId(), user.getLogin(), user.getSenha(), user.getPerfis());
	}
}
