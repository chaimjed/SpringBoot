package com.example.homework.services;


import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.entities.Foyer;
import com.example.homework.repositories.IBlocRepo;
import com.example.homework.repositories.IChambreRepo;
import com.example.homework.repositories.IFoyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepo iblocRepo;
    IFoyerRepo iFoyerRepo;
    IChambreRepo iChambreRepo;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iblocRepo.save(bloc);

    }

    @Override
    public Bloc update(Bloc bloc) {
        return iblocRepo.save(bloc);
    }

    @Override
    public Optional<Bloc> getBlocById(long idBloc) {

        return iblocRepo.findById(idBloc);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public List<Bloc> getBlocALL() {
        return (List<Bloc>) iblocRepo.findAll();
    }

    @Override
    public void deleteBlocById(long idBloc) {
        iblocRepo.deleteById(idBloc);

    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc) {
        Bloc bloc = iblocRepo.findById(idBloc).orElse(null);

        for(Long id:idChambre){
            Chambre chambre = iChambreRepo.findById(id).orElse(null);
            assert chambre != null;
            chambre.setBloc(bloc);
            iChambreRepo.save(chambre);
        }

        return iblocRepo.save(bloc);
    }
    @Transactional
    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = iblocRepo.findById(idBloc).orElse(null);

        Foyer foyer = iFoyerRepo.findById(idFoyer).orElse(null);

        assert bloc != null;
        bloc.setFoyer(foyer);
        iblocRepo.save(bloc);

        return bloc;
    }


}