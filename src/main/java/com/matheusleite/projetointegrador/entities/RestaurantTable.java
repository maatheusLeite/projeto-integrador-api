package com.matheusleite.projetointegrador.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_restaurant_table")
public class RestaurantTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer seatQuantity;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	public RestaurantTable() {
	}

	public RestaurantTable(Long id, Integer seatQuantity, Reservation reservation) {
		super();
		this.id = id;
		this.seatQuantity = seatQuantity;
		this.reservation = reservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSeatQuantity() {
		return seatQuantity;
	}

	public void setSeatQuantity(Integer seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public Reservation getReservation() {
		return reservation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantTable other = (RestaurantTable) obj;
		return Objects.equals(id, other.id);
	}
}
