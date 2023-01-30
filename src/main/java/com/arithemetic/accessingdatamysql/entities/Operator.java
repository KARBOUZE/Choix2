package com.arithemetic.accessingdatamysql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // This tells Hibernate to make a table out of this class
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Operator {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String operator;

}
