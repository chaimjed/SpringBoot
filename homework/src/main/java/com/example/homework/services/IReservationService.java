package com.example.homework.services;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationService  {
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public Optional<Reservation> getReservationById(String idReservation);
    public List<Reservation> getReservationALL();
    public void deleteReservationById(String idReservation);

    @Transactional
    Reservation ajouterReservation(Long idChambre, Long cin);

    @Transactional
    Reservation annulerReservation(Long cinEtudiant);
}
