package com.matheusleite.projetointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusleite.projetointegrador.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
