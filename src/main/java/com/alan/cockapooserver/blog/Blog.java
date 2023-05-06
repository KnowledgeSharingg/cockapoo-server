package com.alan.cockapooserver.blog;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;
    @Column()
    private String url;
    @Column()
    @ColumnDefault("0")
    private Integer views;

}
