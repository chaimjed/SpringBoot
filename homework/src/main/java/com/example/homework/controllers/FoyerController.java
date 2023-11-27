package com.example.homework.controllers;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Foyer;
import com.example.homework.services.IFoyerService;
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
@RequestMapping("api/foyers")
public class FoyerController {
    @Autowired
    IFoyerService foyerService;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f)
    {
        return foyerService.addFoyer(f);
    }
    @GetMapping("/getFoyer")
    public List<Foyer> getFoyer()
    {
        return foyerService.getFoyerALL();
    }
    @GetMapping("/getFoyer/{id}")
    public Optional<Foyer> getFoyerById(@PathVariable long id)
    {
        return foyerService.getFoyerById(id);
    }
    @DeleteMapping("/deleteFoyer/{id}")
    public void deleteFoyerById(@PathVariable long id)
    {
        foyerService.deleteFoyerById(id);
    }
    @PutMapping("/updateChambre")
    public Foyer updateChambre(@RequestBody Foyer f)
    {
        return foyerService.updateFoyer(f);
    }
}

