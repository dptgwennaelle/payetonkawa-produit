package com.payetonkawa.produitservice.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private float price;

    @CsvBindByName
    private String description;

    @CsvBindByName
    private String color;

    @CsvBindByName
    private int stock;

}
