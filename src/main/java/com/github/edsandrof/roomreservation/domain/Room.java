package com.github.edsandrof.roomreservation.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lodging_id", nullable = false)
    private Lodging lodging;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Room room = (Room) o;
        return getId() != null && Objects.equals(getId(), room.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
