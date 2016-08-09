package com.siartim.journal;

import com.siartim.journal.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJournalApplication implements CommandLineRunner {

//    @Bean
//    public InitializingBean saveData(JournalRepository repo) {
//        return new InitializingBean() {
//            @Override
//            public void afterPropertiesSet() throws Exception {
//                repo.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot", "01/01/2016"));
//                repo.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
//                repo.save(new Journal("Spring Boot Reading", "Read more about Spring Boot", "02/01/2016"));
//                repo.save(new Journal("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry", "03/01/2016"));
//            }
//        };
//    }

    private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

    @Autowired
    JournalService service;

    public static void main(String[] args) {

//        SpringApplication app = new SpringApplication(SpringBootJournalApplication.class);
//        app.setBanner((environment, sourceClass, out) -> out.print("\n\n\tThis is my own banner!\n\n".toUpperCase()));
//        app.run(args);

//        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.OFF)
//                .sources(SpringBootJournalApplication.class)
//                .run(args);

//        Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);
//        new SpringApplicationBuilder(SpringBootJournalApplication.class)
//                .listeners(new ApplicationListener<ApplicationEvent>() {
//                    @Override
//                    public void onApplicationEvent(ApplicationEvent event) {
//                        log.info("#### > " + event.getClass().getCanonicalName());
//                    }
//                })
//                .run(args);

        SpringApplication.run(SpringBootJournalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("@@ Inserting Data....");
        service.insertData();
        log.info("@@ findAll() call...");
        service.findAll().forEach(entry -> log.info(entry.toString()));
    }
}
