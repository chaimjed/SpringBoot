package com.example.homework.services;

import com.example.homework.entities.Etudiant;
import com.example.homework.repositories.IEtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiantService{
    @Autowired
    IEtudiantRepo ietudiantRepo;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return ietudiantRepo.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return ietudiantRepo.save(etudiant);
    }

    @Override
    public Optional<Etudiant> getEtudiantById(int idEtudiant) {
        return ietudiantRepo.findById(idEtudiant);
    }


    @Override
    public List<Etudiant> getEtudiantALL() {
        return (List<Etudiant>) ietudiantRepo.findAll();
    }

    @Override
    public void deleteEtudiantById(int idEtudiant) {
        ietudiantRepo.deleteById(idEtudiant);

    }
    @Override
    public List<Etudiant> findByChambreId(Long idChambre){
        return ietudiantRepo.findByChambreId(idChambre);
    }


    public Etudiant findEtudiantByCin(Long cin) {
        return ietudiantRepo.findEtudiantByCin(cin) ;
    }

    @Override
    public List<Etudiant> findByNomEtLike(String nom) {
        return ietudiantRepo.findByNomEtLike(nom) ;
    }

}
