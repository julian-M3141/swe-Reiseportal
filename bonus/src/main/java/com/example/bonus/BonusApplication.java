package com.example.bonus;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBinding(Sink.class)
@EnableScheduling
@Log
public class BonusApplication {

    @Autowired
    IPaymentService paymentService;

    public static void main(String[] args) {
        SpringApplication.run(BonusApplication.class, args);
    }


    //run on first day of every month
    //@Scheduled(cron = "0 0 0 1 * ?",zone = "Europe/Vienna")
    //for testing and show casing run every minute
    @Scheduled(cron = "0 * * * * ?")
    public void run(){
        log.info("initialize payment ...");
        paymentService.payAuthors();
    }

}
