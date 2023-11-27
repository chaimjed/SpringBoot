package com.example.homework.services;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public Optional<Etudiant> getEtudiantById(int idEtudiant);
    public List<Etudiant> getEtudiantALL();
    public void deleteEtudiantById(int idEtudiant);
    List<Etudiant> findByNomEtLike(String nom);
    List<Etudiant> findByChambreId( Long idChambre);

}
