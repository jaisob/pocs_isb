package com.jaime.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogsElkApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(LogsElkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogsElkApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hola");
		logger.info("Prueba Logs hacia consola y fichero");
	}
}
