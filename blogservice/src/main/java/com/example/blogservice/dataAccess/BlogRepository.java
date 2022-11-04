package com.example.blogservice.dataAccess;

import com.example.blogservice.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
