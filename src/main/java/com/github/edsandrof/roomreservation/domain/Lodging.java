package com.github.edsandrof.roomreservation.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "lodging", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms = new HashSet<>();

    private String name;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LodgingCategory category;

    @Enumerated(EnumType.STRING)
    private LodgingType type;
}
