package com.patika.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comm_id")
    private int id;
    private String comment;
    private Date commentDate;
    @Column(name = "prod_id")
    private int productId;
    @Column(name = "user_id")
    private int userId;

    public comment() {
    }

    public comment(int Id , int prodId){
        this.id = Id;
        this.productId = prodId;

    }

}
