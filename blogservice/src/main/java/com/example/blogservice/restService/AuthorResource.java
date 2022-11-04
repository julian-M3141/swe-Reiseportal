package com.example.blogservice.restService;

import com.example.blogservice.dataAccess.AuthorRepository;
import com.example.blogservice.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources/author")
public class AuthorResource {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable long id){
        return authorRepository.findById(id).orElseThrow(()->new EmptyResultDataAccessException("can't find author from id! "+id,1));
    }
}
