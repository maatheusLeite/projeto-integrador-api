package com.matheusleite.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusleite.projetointegrador.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
}
