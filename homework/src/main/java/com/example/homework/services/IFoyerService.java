package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.entities.Foyer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFoyerService  {
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer );
    public Optional<Foyer> getFoyerById(long idFoyer);
    public List<Foyer> getFoyerALL();
    public void deleteFoyerById(long idFoyer);

    @Transactional
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite);
}
