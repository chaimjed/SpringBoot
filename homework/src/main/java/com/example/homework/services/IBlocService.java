package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Foyer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IBlocService {
    public Bloc addBloc(Bloc bloc);
public Bloc update(Bloc bloc);
public Optional<Bloc> getBlocById(long idBloc);
public List<Bloc> getBlocALL();
public void deleteBlocById(long idBloc);

    Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc);

    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer);
}
