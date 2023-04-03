package com.github.edsandrof.roomreservation.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int capacity;

    private int number;

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
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number && Objects.equals(lodging, room.lodging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, lodging);
    }
}
