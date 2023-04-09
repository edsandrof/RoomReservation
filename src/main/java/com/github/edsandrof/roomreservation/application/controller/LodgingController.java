package com.github.edsandrof.roomreservation.application.controller;

import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import com.github.edsandrof.roomreservation.dto.LodgingDTO;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/lodging")
@RequiredArgsConstructor
public class LodgingController {

    private final LodgingService lodgingService;

    @Timed(value = "getLodging.time", description = "Time taken to get lodging by id")
    @GetMapping("/{id}")
    public ResponseEntity<LodgingDTO> findById(@PathVariable Long id) throws InterruptedException {

        Thread.sleep(new Random().nextInt(2001) + 1000);
        Optional<Lodging> lodging = lodgingService.findById(id);

        if (lodging.isPresent()) {
            LodgingDTO lodgingDTO = LodgingDTO.fromEntity(lodging.get());
            return ResponseEntity.ok(lodgingDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
   }

}
