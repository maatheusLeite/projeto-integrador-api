package com.matheusleite.projetointegrador.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusleite.projetointegrador.entities.User;
import com.matheusleite.projetointegrador.repositories.UserRepository;

@Service
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
