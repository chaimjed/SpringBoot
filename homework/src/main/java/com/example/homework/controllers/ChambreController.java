package com.example.homework.controllers;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.services.IChambreService;
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
@RequestMapping("api/chambres")
public class ChambreController {
    IChambreService iChambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c)
    {
        return iChambreService.addChambre(c);
    }
    @GetMapping("/getChambre")
    public List<Chambre> getChambre()
    {
        return iChambreService.getChambreALL();
    }
    @GetMapping("/getChambre/{id}")
    public Optional<Chambre> getChambreById(@PathVariable long id)
    {
        return iChambreService.getChambreById(id);
    }
    @DeleteMapping("/deleteChambre/{id}")
    public void deleteChambreById(@PathVariable long id)
    {
        iChambreService.deleteChambreById(id);
    }
    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre c)
    {
        return iChambreService.updatech(c);
    }
}
