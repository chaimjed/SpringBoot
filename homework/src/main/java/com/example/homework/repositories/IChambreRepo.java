package com.example.homework.repositories;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Reservation;
import com.example.homework.entities.typeChambre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IChambreRepo extends CrudRepository<Chambre,Long>

{
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, typeChambre typeC);
    Chambre findByReservationsContains(Reservation reservation);
    Long countAllByIdChambre(long idChambre);
}
