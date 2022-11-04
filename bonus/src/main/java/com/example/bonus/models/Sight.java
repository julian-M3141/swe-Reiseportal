package com.example.bonus.models;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
public class Sight {
    private Long id;
    private String name;
    private String location;
}
