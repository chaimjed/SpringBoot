package com.example.homework.controllers;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Etudiant;
import com.example.homework.services.IEtudiantService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequestMapping("api/etudiants")
public class EtudiantController {

    IEtudiantService iEtudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e)
    {
        return iEtudiantService.addEtudiant(e);
    }
    @GetMapping("/getEtudiant")
    public List<Etudiant> getEtudiant()
    {
        return iEtudiantService.getEtudiantALL();
    }
    @GetMapping("/getEtudiant/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable int id)
    {
        return iEtudiantService.getEtudiantById(id);
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteChambreById(@PathVariable int id)
    {
        iEtudiantService.deleteEtudiantById(id);
    }
    @PutMapping("/updateChambre")
    public Etudiant updateChambre(@RequestBody Etudiant e)
    {
        return iEtudiantService.updateEtudiant(e);
    }
}
