package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Foyer;
import com.example.homework.entities.Universite;
import com.example.homework.repositories.IBlocRepo;
import com.example.homework.repositories.IFoyerRepo;
import com.example.homework.repositories.IUniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerService implements IFoyerService{
    @Autowired
    IFoyerRepo ifoyerRepo;
    IUniversiteRepo iUniversiteRepo;

     IBlocRepo  iBlocRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return ifoyerRepo.save(foyer) ;
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return ifoyerRepo.save(foyer);
    }

    @Override
    public Optional<Foyer> getFoyerById(long idFoyer) {
        return ifoyerRepo.findById(idFoyer);
    }

    @Override
    public List<Foyer> getFoyerALL() {
        return (List<Foyer>) ifoyerRepo.findAll();
    }

    @Override
    public void deleteFoyerById(long idFoyer) {
        ifoyerRepo.deleteById(idFoyer);

    }

    @Transactional
    @Override


    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite universite = iUniversiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyer(foyer);

        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
            iBlocRepository.save(bloc);
        }

        return foyer;
    }




}