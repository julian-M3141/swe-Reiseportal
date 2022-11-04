package com.example.blogservice.dataAccess;

import com.example.blogservice.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
