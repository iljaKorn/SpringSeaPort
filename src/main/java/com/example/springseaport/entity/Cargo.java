package com.example.springseaport.entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cargo {

    private Integer id;

    private String name;

    private String type;

    private Integer weight;
}
