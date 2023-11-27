package com.example.homework.repositories;

import com.example.homework.entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniversiteRepo extends CrudRepository<Universite,Long> {
List<Universite>findByAdresseLike(String add);

    @Query("SELECT u FROM Universite u JOIN u.foyer f JOIN f.blocs b WHERE b.idBloc = :idBloc")
    Universite findByBlocId(@Param("idBloc") Long idBloc);
}
