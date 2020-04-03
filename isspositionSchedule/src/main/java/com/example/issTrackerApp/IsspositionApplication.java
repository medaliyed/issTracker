package com.example.issTrackerApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IsspositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsspositionApplication.class, args);
	}
	
	private static final Logger logger = LoggerFactory.getLogger(IsspositionApplication.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	//@Scheduled(cron = "0 * * * * ?")
    //@Scheduled(fixedRate = 5000)
	public void scheduleTask() {
	    logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	    
	    
	}

}
