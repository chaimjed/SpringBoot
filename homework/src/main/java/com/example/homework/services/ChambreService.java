package com.example.homework.services;

import com.example.homework.entities.Chambre;
import com.example.homework.repositories.IChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService implements IChambreService{
    @Autowired
    IChambreRepo ichambreRepo;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return ichambreRepo.save(chambre);
    }

    @Override
    public Chambre updatech(Chambre chambre) {
        return ichambreRepo.save(chambre);
    }

    @Override
    public Optional<Chambre> getChambreById(long idChambre) {
        return ichambreRepo.findById(idChambre);
    }

    @Override
    public List<Chambre> getChambreALL() {
        return (List<Chambre>) ichambreRepo.findAll();
    }

    @Override
    public void deleteChambreById(long idChambre) {
        ichambreRepo.deleteById(idChambre);

    }

    @Override
    public Long countAllByIdChambre(long idChambre) {
        return ichambreRepo.countAllByIdChambre(idChambre);
    }
}
