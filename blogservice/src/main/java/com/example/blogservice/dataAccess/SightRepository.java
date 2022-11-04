package com.example.blogservice.dataAccess;

import com.example.blogservice.models.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Long> {
}
