package com.github.edsandrof.roomreservation.dto;

import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.LodgingCategory;
import com.github.edsandrof.roomreservation.domain.LodgingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

public class LodgingDTO implements Serializable {

    private static final long serialVersionUID = -1049289044666275104L;
    private Long id;
    private Set<RoomDTO> rooms;
    private String name;
    private String phoneNumber;
    private LodgingCategory category;
    private LodgingType type;

    public static LodgingDTO fromEntity(Lodging lodging) {
        Set<RoomDTO> rooms = lodging.getRooms().stream()
                .map(RoomDTO::fromEntity)
                .collect(Collectors.toSet());;

        return LodgingDTO.builder()
                .id(lodging.getId())
                .rooms(rooms)
                .name(lodging.getName())
                .phoneNumber(lodging.getPhoneNumber())
                .category(lodging.getCategory())
                .type(lodging.getType())
                .build();
    }
}