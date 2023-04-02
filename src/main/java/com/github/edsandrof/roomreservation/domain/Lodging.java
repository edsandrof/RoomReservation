package com.github.edsandrof.roomreservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "lodging", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms = new HashSet<>();

    private String name;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LodgingCategory category;

    @Enumerated(EnumType.STRING)
    private LodgingType type;
}
