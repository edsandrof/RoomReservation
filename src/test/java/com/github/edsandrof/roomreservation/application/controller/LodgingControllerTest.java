package com.github.edsandrof.roomreservation.application.controller;

import com.github.edsandrof.roomreservation.TestFactory;
import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.Room;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class LodgingControllerTest {

    @Mock
    private LodgingService lodgingService;

    private LodgingController lodgingController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(lodgingController).build();
        this.lodgingController = new LodgingController(lodgingService);
    }

    @Test
    @DisplayName("Retorna lodging por id")
    public void testGetLodgingById() throws Exception {

        Long lodgingId = 1L;

        Lodging lodging = TestFactory.createLogding();
        Room room = TestFactory.createRoom(lodging);

        lodging.setRooms(new HashSet<>(Collections.singleton(room)));

        Mockito.when(lodgingService.findById(anyLong()))
                .thenReturn(lodging);


        mockMvc.perform(MockMvcRequestBuilders.get("/lodging/{id}", lodgingId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\" : 1}"));

    }

}

