package com.matheusleite.projetointegrador.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusleite.projetointegrador.entities.RestaurantTable;
import com.matheusleite.projetointegrador.repositories.RestaurantTableRepository;

@Service
public class RestaurantTableService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	RestaurantTableRepository repository;

	public List<RestaurantTable> findAll() {
		return repository.findAll();
	}

	public RestaurantTable findById(Long id) {
		Optional<RestaurantTable> obj = repository.findById(id);
		return obj.get();
	}
}