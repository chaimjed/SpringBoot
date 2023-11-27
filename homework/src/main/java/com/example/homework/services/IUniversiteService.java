package com.example.homework.services;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Universite;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUniversiteService   {
    public Universite addUniversite(Universite universite);
    public Universite updateUniversite(Universite universite);
    public Optional<Universite> getUniversiteById(long idUniversite);
    public List<Universite> getUniversiteALL();
    public void deleteUniversiteById(long idUniversite);
    List<Universite>findByAdresseLike(String add);
    List<Universite>findByBlocId(Long idBloc);


}
