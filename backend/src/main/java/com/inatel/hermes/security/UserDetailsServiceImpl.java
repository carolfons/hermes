package com.inatel.hermes.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.inatel.hermes.entities.Usuario;
import com.inatel.hermes.services.UsuarioService;

@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userService.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		} else {
			return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
		}
	}

}
