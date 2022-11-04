package com.example.bonus;

import com.example.bonus.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AuthorController {

    @Autowired
    private RestTemplate restTemplate;

    public List<Author> getAuthors(){
        ResponseEntity<List<Author>> response = restTemplate.exchange(
                "http://BLOGSERVICE/resources/author",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
