package com.example.blogservice.restService;

import com.example.blogservice.dataAccess.BlogRepository;
import com.example.blogservice.models.Blog;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/resources/blog")
@Log
public class BlogResource {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private Source source;

    @GetMapping
    public List<Blog> getAll(){
        return blogRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
    public Blog getById(@PathVariable long id){
        Blog blog = blogRepository.findById(id).orElseThrow(()->new EmptyResultDataAccessException("can't find blog from id! "+id,1));
        sendMessage(blog);
        log.info("send blog: "+blog);
        return blog;
    }

    @PostMapping
    public ResponseEntity<?> createNewBlog(@RequestBody Blog blog){
        log.info("create new blog: "+blog);
        blog.setId(null);
        blog = blogRepository.save(blog);

        //sendMessage(blog);

        URI location = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(getClass()).getById(blog.getId())
        ).toUri();

        return ResponseEntity.created(location).build();
    }

    private void sendMessage(Blog blog) {
        Message<Blog> message = MessageBuilder
                .withPayload(blog)
                .build();

        source.output().send(message);
    }
}
