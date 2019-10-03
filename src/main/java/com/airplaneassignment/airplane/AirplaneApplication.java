package com.airplaneassignment.airplane;

import com.airplaneassignment.airplane.models.Airplane;
import com.airplaneassignment.airplane.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class AirplaneApplication {

	@Autowired
	private AirplaneRepository airplaneRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationStart() throws IOException {
		Airplane testPlane = new Airplane(1135784L, 5, "Boeing", "787");
		Airplane testPlane2 = new Airplane(1135784L, 3, "Boeing", "777");

		this.airplaneRepository.saveAndFlush(testPlane); // Testing code

		this.airplaneRepository.saveAndFlush(testPlane2); // Testing code
	}

	public static void main(String[] args) {
		SpringApplication.run(AirplaneApplication.class, args);
	}

}
