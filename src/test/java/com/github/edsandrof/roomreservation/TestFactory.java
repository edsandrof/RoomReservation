package com.github.edsandrof.roomreservation;

import com.github.edsandrof.roomreservation.domain.*;

public abstract class TestFactory {

    public static Lodging createLogding() {
        return new Lodging().toBuilder()
                .id(1L)
                .name("lodging")
                .phoneNumber("12345678")
                .type(LodgingType.HOTEL)
                .category(LodgingCategory.EXPRESS)
                .build();
    }

    public static Room createRoom(Lodging lodging) {
        return new Room().toBuilder()
                .lodging(lodging)
                .id(1L)
                .type(RoomType.BASIC)
                .capacity(3)
                .status(RoomStatus.AVAILABLE)
                .build();
    }
}
