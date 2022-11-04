package com.example.bonus.dataAccess;


import com.example.bonus.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {
    List<Request> findAllByTimestampAfter(LocalDateTime date);
}
