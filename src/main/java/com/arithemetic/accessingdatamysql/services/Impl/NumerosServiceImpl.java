package com.arithemetic.accessingdatamysql.services.Impl;

import com.arithemetic.accessingdatamysql.entities.Numeros;
import com.arithemetic.accessingdatamysql.repositorys.NumeroRepository;
import com.arithemetic.accessingdatamysql.services.NumerosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NumerosServiceImpl implements NumerosService {

    @Autowired
    private NumeroRepository numerosRepository;

    @Override
    public void insertNumbers(){
        long numberNmbs = numerosRepository.count();
        if(numberNmbs < 20){
            List<Numeros> newNumeros = new ArrayList<>();
            for (int i = 1; i<=20; i++){
                Numeros nb = new Numeros(i,i);
                newNumeros.add(nb);
            }
            newNumeros.forEach(nb -> numerosRepository.save(nb));
        }
    }

    @Override
    public Numeros getNumber(int id){
        return numerosRepository.findNumerosByNumber(id);
    }

}
