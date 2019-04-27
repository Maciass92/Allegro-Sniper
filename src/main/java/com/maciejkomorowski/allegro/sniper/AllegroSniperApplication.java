package com.maciejkomorowski.allegro.sniper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AllegroSniperApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllegroSniperApplication.class, args);
	}

}
