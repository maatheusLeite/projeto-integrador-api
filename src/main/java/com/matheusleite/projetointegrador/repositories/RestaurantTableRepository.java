package com.matheusleite.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusleite.projetointegrador.entities.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

}
