package com.example.homework.controllers;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Reservation;
import com.example.homework.services.IReservationService;
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
@RequestMapping("api/reservations")
public class ReservationController {

    IReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r)
    {
        return reservationService.addReservation(r);
    }
    @GetMapping("/getReservation")
    public List<Reservation> getChambre()
    {
        return reservationService.getReservationALL();
    }
    @GetMapping("/getReservation/{id}")
    public Optional<Reservation> getReservationById(@PathVariable String id)
    {
        return reservationService.getReservationById(id);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservationById(@PathVariable String id)
    {
        reservationService.deleteReservationById(id);
    }
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r)
    {
        return reservationService.updateReservation(r);
    }
}

