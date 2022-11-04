package com.example.bonus.models;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor  // optional since default
@Getter
@ToString
public class Author {
    private Long id;
    private String firstName;
    private String lastName;

}
