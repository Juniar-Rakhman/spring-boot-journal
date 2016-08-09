package com.siartim.journal.service;

import com.siartim.journal.model.JournalEntry;
import com.siartim.journal.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by a9jr5626 on 8/9/16.
 */
@Service
public class JournalService {

    private static final Logger log = LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JournalRepository repo;

    public void insertData() throws ParseException {
        log.info("> Inserting data...");
        repo.save(new JournalEntry("Get to know Spring Boot", "Today I will learn Spring Boot", "01/01/2016"));
        repo.save(new JournalEntry("Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
        repo.save(new JournalEntry("Spring Boot Reading", "Read more about Spring Boot", "02/01/2016"));
        repo.save(new JournalEntry("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry", "03/01/2016"));
        log.info("> Done.");
    }

    public List<JournalEntry> findAll() {
        return repo.findAll();
    }
}
