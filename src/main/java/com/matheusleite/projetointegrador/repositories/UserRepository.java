package com.matheusleite.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusleite.projetointegrador.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
