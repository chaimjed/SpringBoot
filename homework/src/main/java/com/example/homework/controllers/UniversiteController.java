package com.example.homework.controllers;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Universite;
import com.example.homework.services.IUniversiteService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequestMapping("api/universites")
public class UniversiteController {
    IUniversiteService universiteService;

    @PostMapping("/addUniversite")
    public Universite addBloc(@RequestBody Universite c)
    {
        return universiteService.addUniversite(c);
    }
    @GetMapping("/getUniversite")
    public List<Universite> getChambre()
    {
        return universiteService.getUniversiteALL();
    }
    @GetMapping("/getUniversite/{id}")
    public Optional<Universite> getChambreById(@PathVariable long id)
    {
        return universiteService.getUniversiteById(id);
    }
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteChambreById(@PathVariable long id)
    {
        universiteService.deleteUniversiteById(id);
    }
    @PutMapping("/updateChambre")
    public Universite updateChambre(@RequestBody Universite c)
    {
        return universiteService.updateUniversite(c);
    }
}

