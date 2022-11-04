package com.example.bonus;

import com.example.bonus.dataAccess.RequestRepository;
import com.example.bonus.models.Blog;
import com.example.bonus.models.Request;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Log
public class BonusService {

    @Autowired
    private RequestRepository repository;

    @StreamListener(Sink.INPUT)
    public void handleEvent(Blog blog){
        log.info("new Request: "+blog);
        Request request = repository.save(new Request(LocalDateTime.now(), blog.getAuthor().getId()));
        log.info(request.toString());
    }
}
