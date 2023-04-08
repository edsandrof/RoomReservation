package com.github.edsandrof.roomreservation.dto;

import com.github.edsandrof.roomreservation.domain.Room;
import com.github.edsandrof.roomreservation.domain.RoomStatus;
import com.github.edsandrof.roomreservation.domain.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Serializable {

    private static final long serialVersionUID = 7924008688127028927L;

    private Long id;
    private int capacity;
    private int number;
    private RoomType type;
    private RoomStatus status;

    public static RoomDTO fromEntity(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .capacity(room.getCapacity())
                .number(room.getNumber())
                .type(room.getType())
                .status(room.getStatus())
                .build();
    }
}