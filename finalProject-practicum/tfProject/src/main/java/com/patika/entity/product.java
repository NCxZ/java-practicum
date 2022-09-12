package com.patika.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private double price;
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id" , referencedColumnName = "id")
    private List<comment> comments;


    public product(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public product() {
    }
}
