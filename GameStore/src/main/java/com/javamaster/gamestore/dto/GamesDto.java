package com.javamaster.gamestore.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GamesDto { //со стороны пользователя
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private Date releaseDate;
    private short rating;
    private String picture;
}
