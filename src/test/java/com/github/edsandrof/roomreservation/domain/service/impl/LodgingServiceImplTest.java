package com.github.edsandrof.roomreservation.domain.service.impl;

import com.github.edsandrof.roomreservation.TestFactory;
import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.Room;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import com.github.edsandrof.roomreservation.infrastructure.repository.LodgingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class LodgingServiceImplTest {

    @Mock
    private LodgingRepository lodgingRepository;

    private LodgingService lodgingServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.lodgingServiceImpl = new LodgingServiceImpl();
    }

    @Test
    @DisplayName("Retorna lodging por id")
    void testFindById() {

        Lodging lodging = TestFactory.createLogding();
        lodging.setId(1L);
        Room room = TestFactory.createRoom(lodging);

        lodging.setRooms(new HashSet<>(Collections.singleton(room)));

        when(lodgingRepository.findById(anyLong()))
                .thenReturn(Optional.of(lodging));

        Optional<Lodging> optional = lodgingServiceImpl.findById(1L);
        Lodging result = optional.orElse(null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
    }
}
