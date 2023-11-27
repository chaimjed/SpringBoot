package com.example.homework.services;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Etudiant;
import com.example.homework.entities.Reservation;
import com.example.homework.entities.typeChambre;
import com.example.homework.repositories.IChambreRepo;
import com.example.homework.repositories.IEtudiantRepo;
import com.example.homework.repositories.IReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    IReservationRepo ireservationRepo;
     IChambreRepo chambreRepository;
     IEtudiantRepo etudiantRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return ireservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return ireservationRepo.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservationById(String idReservation) {
        return ireservationRepo.findById(idReservation);
    }

    @Override
    public List<Reservation> getReservationALL() {
        return (List<Reservation>) ireservationRepo.findAll();
    }

    @Override
    public void deleteReservationById(String idReservation) {
ireservationRepo.deleteById(idReservation);
    }


    @Transactional
    @Override
    public Reservation ajouterReservation (Long idChambre, Long cin)  {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

        Etudiant etudiant = etudiantRepository.findEtudiantByCin(cin);

        // Création de la réservation
        Reservation reservation = new Reservation();
        assert chambre != null;
        reservation.setAnneeUniversitaire(reservation.getAnneeUniversitaire());

        reservation.setEstValide(true);

        int capaciteMax = 0;
        if (typeChambre.SIMPLE.equals(chambre.getTypeC())) {
            capaciteMax = 1;
        } else if (typeChambre.DOUBLE.equals(chambre.getTypeC())) {
            capaciteMax = 2;
        } else if (typeChambre.TRIPLE.equals(chambre.getTypeC())) {
            capaciteMax = 3;
        }

        long nombreReservations = chambre.getReservations().size();
        if (nombreReservations >= capaciteMax) {
            throw new IllegalStateException("La capacité maximale de la chambre est atteinte.");
        }

        // Gérer la relation ManyToMany
        Set<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        // Sauvegarder la réservation
        Reservation savedReservation = ireservationRepo.save(reservation);

        chambre.getReservations().add(savedReservation);
        chambreRepository.save(chambre);

        return savedReservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findEtudiantByCin(cinEtudiant);

        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiants().remove(etudiant);

        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservations().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return ireservationRepo.save(reservation);
    }
}