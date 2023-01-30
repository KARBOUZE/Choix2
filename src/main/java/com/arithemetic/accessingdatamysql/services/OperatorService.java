package com.arithemetic.accessingdatamysql.services;

import com.arithemetic.accessingdatamysql.entities.Operator;
import org.springframework.ui.Model;

import java.util.List;

public interface OperatorService {
    public void insertOperators();
    public Operator getOperator(int id);
}
