package com.microservices.learning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "microservice")
@ToString()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "ID" )
    public String userId;

    @Column(name = "NAME" )
    public String name;

    @Column(name = "EMAIL" )
    public String email;

    @Column(name = "ABOUT" )
    public String about;

    @Transient
    public List<Rating> ratings = new ArrayList<>();

}