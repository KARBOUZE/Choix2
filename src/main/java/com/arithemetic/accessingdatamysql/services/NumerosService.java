package com.arithemetic.accessingdatamysql.services;

import com.arithemetic.accessingdatamysql.entities.Numeros;
import org.springframework.ui.Model;

import java.util.List;

public interface NumerosService {
    public void insertNumbers();
    public Numeros getNumber(int id);
}
