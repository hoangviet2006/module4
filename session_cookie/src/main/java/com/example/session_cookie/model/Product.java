package com.example.session_cookie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code" ,unique = true, nullable = false)
    private String code;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "img" , nullable = false)
    private String img;
    @Column(name = "price" , nullable = false)
    private Double price;
    @Column(name = "quantity" , nullable = false)
    private int quantity;
}
