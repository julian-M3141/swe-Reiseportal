package com.example.blogservice.restService;

import com.example.blogservice.dataAccess.SightRepository;
import com.example.blogservice.models.Sight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources/sight")
public class SightResource {
    @Autowired
    private SightRepository sightRepository;

    @GetMapping
    public List<Sight> getAll(){
        return sightRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sight getById(@PathVariable long id){
        return sightRepository.findById(id).orElseThrow(()->new EmptyResultDataAccessException("can't find sight from id! "+id,1));
    }
}
