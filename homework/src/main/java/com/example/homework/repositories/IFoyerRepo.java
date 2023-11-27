package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Foyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoyerRepo extends CrudRepository<Foyer,Long> {
    //List<Bloc> findByCapaciteFoyer(long capaciteFoyer);

}
