package com.example.bonus.models;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
public class Blog {
    private Long id;
    private Author author;
    private Sight sight;
    private String title;
    private String text;

}
