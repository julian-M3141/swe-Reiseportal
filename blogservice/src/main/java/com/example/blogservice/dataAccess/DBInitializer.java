package com.example.blogservice.dataAccess;

import com.example.blogservice.models.Author;
import com.example.blogservice.models.Blog;
import com.example.blogservice.models.Sight;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log
public class DBInitializer {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private SightRepository sightRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void initialize(){
        var sights = sightRepository.saveAll(List.of(
                new Sight("Stephansdom", "Wien"),
                new Sight("Wörtersee", "Kärnten"),
                new Sight("Goldene Dachl", "Innsbruck"),
                new Sight("Uhrturm", "Graz")
        ));

        var authors = authorRepository.saveAll(List.of(
              new Author("Max", "Musterbloger"),
              new Author("Martina", "Musterblogerin"),
              new Author("Markus", "Mustermann"),
              new Author("Martina", "Musterfrau")
        ));

        blogRepository.saveAll(List.of(
                new Blog(authors.get(0), sights.get(0), "Meine Reise zum Stephansdom", "text text text text text text")
        ));
    }
}
