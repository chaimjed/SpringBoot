package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Chambre")

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter

@ToString (exclude = {"idChambre"})
public class Chambre implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    @Column(nullable = false)

    long numeroChambre;
    @Enumerated(EnumType.STRING)
    private typeChambre typeC;
    @ManyToOne
    Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
