package com.inatel.hermes.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_roles")
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	private String nomeRole;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> users;

	public Role() {

	}

	public Role(String nomeRole, List<Usuario> users) {
		this.nomeRole = nomeRole;
		this.users = users;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	

}
