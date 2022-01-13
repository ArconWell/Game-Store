package com.javamaster.gamestore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="games")
@Data //ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor //ломбок аннотация: конструктор без аргуметов
public class Games { //со стороны базы данных

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column
    private short rating;

    @Column
    private String picture;
}
