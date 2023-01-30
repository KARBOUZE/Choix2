package com.arithemetic.accessingdatamysql.services.Impl;

import com.arithemetic.accessingdatamysql.entities.Operator;
import com.arithemetic.accessingdatamysql.repositorys.OperatorRepository;
import com.arithemetic.accessingdatamysql.services.OperatorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public void insertOperators(){
        long numberOperatores = operatorRepository.count();
        if(numberOperatores < 4){
            List<Operator> newOperators = Arrays.asList(new Operator(1,"+"),new Operator(2, "-"),new Operator(3,"/"),new Operator(4,"*"));
            newOperators.forEach(r -> operatorRepository.save(r));
        }
    }

    @Override
    public Operator getOperator(int id){
        return  operatorRepository.findById(id).get();
    }

}
