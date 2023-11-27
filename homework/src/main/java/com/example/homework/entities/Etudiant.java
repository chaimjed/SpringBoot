package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Etudiant")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString (exclude = {"idEtudiant"})
@Getter

public class Etudiant implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;

    @Column(nullable = false)
    String nomEt;

    @Column(nullable = false)
    String prenomEt;

    @Column(nullable = false)
    long cin;

    @Column(nullable = false)
    String ecole;

    @Column(nullable = false)
    Date dateNaissance;
   @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
