package com.matheusleite.projetointegrador.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reservation")
public class Reservation implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer peopleAmount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant generationMoment;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant bookedDate;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	public Reservation() {
	}

	public Reservation(Long id, Integer peopleAmount,Instant generationMoment, Instant bookedDate,User client) {
		super();
		this.id = id;
		this.peopleAmount = peopleAmount;
		this.generationMoment = generationMoment;
		this.bookedDate = bookedDate;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPeopleAmount() {
		return peopleAmount;
	}

	public void setPeopleAmount(Integer peopleAmount) {
		this.peopleAmount = peopleAmount;
	}

	public Instant getGenerationMoment() {
		return generationMoment;
	}

	public void setGenerationMoment(Instant generationMoment) {
		this.generationMoment = generationMoment;
	}

	public Instant getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Instant bookedDate) {
		this.bookedDate = bookedDate;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}
}
