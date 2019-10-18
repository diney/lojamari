package com.lojamari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lojamari.domain.Admin;
import com.lojamari.repository.AdminRepository;
import com.lojamari.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository repo;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {

		Admin adm = repo.findByNome(nome);
		if (adm == null) {
			throw new UsernameNotFoundException(nome);
		}
		
		return new UserSS(adm.getId(), adm.getNome(), adm.getSenha(), adm.getPerfil());

	}

}
