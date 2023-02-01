package com.matheusleite.projetointegrador.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusleite.projetointegrador.entities.Reservation;
import com.matheusleite.projetointegrador.entities.RestaurantTable;
import com.matheusleite.projetointegrador.entities.User;
import com.matheusleite.projetointegrador.repositories.ReservationRepository;
import com.matheusleite.projetointegrador.repositories.RestaurantTableRepository;
import com.matheusleite.projetointegrador.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired 
	private RestaurantTableRepository restaurantTableRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Carlos Brown", "carlos@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Maria Gray", "maria@gmail.com", "955555555", "123456");
		User u4 = new User(null, "Helena Blue", "helena@gmail.com", "944444444", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
			
		Reservation r1 = new Reservation(null, Instant.parse("2022-06-20T19:53:07Z"), Instant.parse("2022-06-22T15:00:00Z"), u1);
		Reservation r2 = new Reservation(null, Instant.parse("2022-06-25T08:03:01Z"), Instant.parse("2022-06-25T18:00:00Z"), u4);
		
		reservationRepository.saveAll(Arrays.asList(r1, r2));
		
		RestaurantTable t1 = new RestaurantTable(null, 4, r1);
		RestaurantTable t3 = new RestaurantTable(null, 4, r2);
		RestaurantTable t4 = new RestaurantTable(null, 4, r2);
		
		restaurantTableRepository.saveAll(Arrays.asList(t1, t3, t4));
	}

}
