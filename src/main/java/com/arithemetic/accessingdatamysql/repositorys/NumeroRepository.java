package com.arithemetic.accessingdatamysql.repositorys;

import com.arithemetic.accessingdatamysql.entities.Numeros;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NumeroRepository extends CrudRepository<Numeros, Integer> {

    Numeros findNumerosByNumber(int nb);
}
