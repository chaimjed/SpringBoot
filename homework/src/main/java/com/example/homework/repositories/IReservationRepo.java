package com.example.homework.repositories;

import com.example.homework.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepo extends CrudRepository<Reservation,String> {


    //List<Reservation> findByAnneeUniversitaireBetween(Date dfrom, Date dTo);

  //  @Query("SELECT r FROM Reservation r JOIN Chambre c on r member c.reservations where c.blocs.idBloc=5")
   // List<Reservation> findAllActiveReservationsByBlocId(@Param("idBloc") Long idBloc);
}