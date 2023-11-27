package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@ToString (exclude = {"idBloc"})
public class Bloc implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    @Column(nullable = false)
    String nomBloc;
    @Column(nullable = false)
    long capaciteBloc;
@ManyToOne
    Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bloc")
    private Set<Chambre> chambres;
}
