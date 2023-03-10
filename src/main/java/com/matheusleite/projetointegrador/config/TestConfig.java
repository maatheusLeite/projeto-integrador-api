package com.matheusleite.projetointegrador.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusleite.projetointegrador.entities.Admin;
import com.matheusleite.projetointegrador.entities.Reservation;
import com.matheusleite.projetointegrador.entities.User;
import com.matheusleite.projetointegrador.repositories.AdminRepository;
import com.matheusleite.projetointegrador.repositories.ReservationRepository;
import com.matheusleite.projetointegrador.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Carlos Brown", "carlos@gmail.com", "11988888888", "12345678");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "11977777777", "12345678");
		User u3 = new User(null, "Maria Gray", "maria@gmail.com", "11955555555", "12345678");
		User u4 = new User(null, "Helena Blue", "helena@gmail.com", "11944444444", "12345678");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
			
		Reservation r1 = new Reservation(null, 5, Instant.parse("2022-06-20T19:53:07Z"), Instant.parse("2022-06-22T15:00:00Z"), u1);
		Reservation r2 = new Reservation(null, 8, Instant.parse("2022-06-25T08:03:01Z"), Instant.parse("2022-06-25T18:00:00Z"), u4);
		
		reservationRepository.saveAll(Arrays.asList(r1, r2));
		
		Admin a1 = new Admin(null, "MatheusLeite", "admin1234");
		
		adminRepository.save(a1);
	}
}
