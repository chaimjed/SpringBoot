package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="Reservation")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString (exclude = {"idRes"})
@Getter

public class Reservation  implements Serializable {
    @Id
    @EqualsAndHashCode.Exclude
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String idRes;

    @Column(nullable = false)
    Date anneeUniversitaire;

    @Column(nullable = false)
    boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
