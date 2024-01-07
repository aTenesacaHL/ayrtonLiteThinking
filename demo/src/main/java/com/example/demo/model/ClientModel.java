package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String secondname;
    private String firstlastname;
    private String secondlastname;
    private String documentType;
    private String documentnumber;
    private String numberPhone;
    private String address;
    private String email;



}
