package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Foyer")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString (exclude = {"idFoyer"})
@Getter

public class Foyer implements Serializable {
    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer ;

    @Column(nullable = false)
    String nomFoyer;

    @Column(nullable = false)
    long capaciteFoyer ;
    @OneToOne
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Set<Bloc> blocs;
}
