package com.siartim.journal;

import com.siartim.journal.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJournalApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    @Autowired
    JournalService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(JournalService service){
        return args -> {
            log.info("@@ Inserting Data....");
            service.insertData();
            log.info("@@ findAll() call...");
            service.findAll().forEach(entry -> log.info(entry.toString()));
        };
    }
}
