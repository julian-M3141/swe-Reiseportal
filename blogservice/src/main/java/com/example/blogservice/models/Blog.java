package com.example.blogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_Blog")
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "Author_id")
    Author author;
    @ManyToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "Sight_id")
    Sight sight;
    @Column(nullable = false, length = 50)
    String title;
    @Column(nullable = false)
    String text;

    public Blog(Author author, Sight sight, String title, String text) {
        this(null, author, sight, title, text);
    }
}
