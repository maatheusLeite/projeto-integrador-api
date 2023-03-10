package com.matheusleite.projetointegrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusleite.projetointegrador.entities.Admin;
import com.matheusleite.projetointegrador.services.AdminService;

@RestController
@RequestMapping(value = "/admins")
public class AdminResource {
	
	@Autowired
	private AdminService service;

	@CrossOrigin()
	@GetMapping
	public ResponseEntity<List<Admin>> findAll() {
		List<Admin> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin()  
	@GetMapping(value = "/{id}")
	public ResponseEntity<Admin> findById(@PathVariable Long id) {
		Admin obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin()
	@PostMapping
	public ResponseEntity<Admin> insert(@RequestBody Admin obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@CrossOrigin()
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
