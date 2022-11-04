package com.example.bonus.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    LocalDateTime timestamp;

    @Column(nullable = false)
    Long fk_author;

    public Request(LocalDateTime timestamp, Long fk_author) {
        this(null,timestamp,fk_author);
    }
}
