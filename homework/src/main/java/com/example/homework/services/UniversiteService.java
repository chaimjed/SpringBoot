package com.example.homework.services;

import com.example.homework.entities.Foyer;
import com.example.homework.entities.Universite;
import com.example.homework.repositories.IUniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepo iUniversiteRepo;

    @Override
    public Universite addUniversite(Universite universite) {
        return iUniversiteRepo.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return iUniversiteRepo.save(universite);
    }

    @Override
    public Optional<Universite> getUniversiteById(long idUniversite) {
        return iUniversiteRepo.findById(idUniversite);
    }

    @Override
    public List<Universite> getUniversiteALL() {
        return (List<Universite>) iUniversiteRepo.findAll();
    }

    @Override
    public void deleteUniversiteById(long idUniversite) {
iUniversiteRepo.deleteById(idUniversite);
    }

    @Override
    public List<Universite> findByAdresseLike(String add) {
        return iUniversiteRepo.findByAdresseLike(add);
    }

    @Override
    public List<Universite> findByBlocId(Long idBloc) {
        return (List<Universite>) iUniversiteRepo.findByBlocId(idBloc);
    }
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = rechercheUniversiteParNom(nomUniversite);

        if (universite != null) {
            Foyer foyer = new Foyer();
            foyer.setIdFoyer(idFoyer);
            foyer.setNomFoyer("Nom du foyer");

            universite.setFoyer(foyer);
        }

        return universite;
    }

    private Universite rechercheUniversiteParNom(String nomUniversite) {
        List<Universite>Lista = new ArrayList<>();

        for (Universite universite : Lista) {
            if (universite.getNomUniversite().equals(nomUniversite)) {
                return universite;
            }
        }

        return null;
    }
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = rechercheUniversiteParId(idUniversite);

        if (universite != null) {
            universite.setFoyer(null);
        }

        return universite;
    }

    private Universite rechercheUniversiteParId(long idUniversite) {
        List<Universite>Lista = new ArrayList<>();

        for (Universite universite : Lista) {
            if (universite.getIdUniversite() == idUniversite) {
                return universite;
            }
        }

        return null;
    }

}


