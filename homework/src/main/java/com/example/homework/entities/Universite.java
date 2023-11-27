package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="Universite")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString (exclude = {"idUniversite"})
@EqualsAndHashCode
public class Universite implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;

    @Column(nullable = false)
    String nomUniversite;

    @Column(nullable = false)
    String adresse;
    @OneToOne(mappedBy = "universite")
    private Foyer foyer;

}
