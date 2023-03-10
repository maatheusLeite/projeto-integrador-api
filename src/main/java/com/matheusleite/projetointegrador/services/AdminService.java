package com.matheusleite.projetointegrador.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusleite.projetointegrador.entities.Admin;
import com.matheusleite.projetointegrador.repositories.AdminRepository;

@Service
public class AdminService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	AdminRepository repository;

	public List<Admin> findAll() {
		return repository.findAll();
	}

	public Admin findById(Long id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.get();
	}
	
	public Admin insert(Admin obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}