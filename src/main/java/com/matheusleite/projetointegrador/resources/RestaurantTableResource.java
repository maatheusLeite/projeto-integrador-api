package com.matheusleite.projetointegrador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusleite.projetointegrador.entities.RestaurantTable;
import com.matheusleite.projetointegrador.services.RestaurantTableService;

@RestController
@RequestMapping(value = "/tables")
public class RestaurantTableResource {
	
	@Autowired
	private RestaurantTableService service;

	@GetMapping
	public ResponseEntity<List<RestaurantTable>> findAll() {
		List<RestaurantTable> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RestaurantTable> findById(@PathVariable Long id) {
		RestaurantTable obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
