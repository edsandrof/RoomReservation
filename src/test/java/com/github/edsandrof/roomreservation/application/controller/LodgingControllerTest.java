package com.github.edsandrof.roomreservation.application.controller;

import com.github.edsandrof.roomreservation.TestFactory;
import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.Room;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LodgingController.class)
public class LodgingControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private LodgingService lodgingService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @Test
    @DisplayName("Retorna lodging por id")
    void testGetLodgingById() throws Exception {

        Lodging lodging = TestFactory.createLogding();
        Room room = TestFactory.createRoom(lodging);

        lodging.setRooms(new HashSet<>(Collections.singleton(room)));

        when(lodgingService.findById(anyLong()))
                .thenReturn(Optional.of(lodging));

        mockMvc.perform(get("/lodging/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"rooms\":[{\"id\":1,\"capacity\":3,\"number\":0,\"type\":\"BASIC\",\"status\":\"AVAILABLE\"}],\"name\":\"lodging\",\"phoneNumber\":\"12345678\",\"category\":\"EXPRESS\",\"type\":\"HOTEL\"}"))
                .andDo(print());
    }
}

