package com.matheusleite.projetointegrador.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusleite.projetointegrador.entities.Reservation;
import com.matheusleite.projetointegrador.repositories.ReservationRepository;

@Service
public class ReservationService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	ReservationRepository repository;

	public List<Reservation> findAll() {
		return repository.findAll();
	}

	public Reservation findById(Long id) {
		Optional<Reservation> obj = repository.findById(id);
		return obj.get();
	}
	
	public Reservation insert(Reservation obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}