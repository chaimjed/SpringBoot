package com.example.homework.services;

import com.example.homework.entities.Chambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public Chambre updatech(Chambre chambre);
    public Optional<Chambre> getChambreById(long idChambre);
    public List<Chambre> getChambreALL();
    public void deleteChambreById(long idChambre);
    Long countAllByIdChambre(long idChambre);

}
