package com.example.homework.controllers;

import com.example.homework.entities.Bloc;
import com.example.homework.services.IBlocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/blocs")
public class BlocController {
    IBlocService iBlocService;
    @PostMapping("/addBloc")
    @Tag(name = "gestion bloc")
    @Operation(description = "test")
    public Bloc addBloc(@RequestBody Bloc b)
    {
        return iBlocService.addBloc(b);
    }
    @GetMapping("/getBloc")
    public List<Bloc> getBloc()
    {
        return iBlocService.getBlocALL();
    }
    @GetMapping("/getBloc/{id}")
    public Optional<Bloc> getBlocById(@PathVariable long id)
    {
        return iBlocService.getBlocById(id);
    }
    @DeleteMapping("/deletebloc/{id}")
    public void deleteById(@PathVariable long id)
    {
         iBlocService.deleteBlocById(id);
    }
    @PutMapping("/updatebloc")
    public Bloc updateBloc(@RequestBody Bloc b)
    {
        return iBlocService.update(b);
    }
}
