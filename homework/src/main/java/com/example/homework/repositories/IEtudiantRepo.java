package com.example.homework.repositories;

import com.example.homework.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantRepo extends CrudRepository<Etudiant, Integer> {
    List<Etudiant> findByNomEtLike(String nom);
    Etudiant findEtudiantByCin(Long cin);

    @Query("SELECT e FROM Etudiant e JOIN e.reservations r JOIN Chambre c on r member c.reservations where  c.idChambre = :idChambre")
    List<Etudiant> findByChambreId(@Param("idChambre") Long idChambre);


}
