package com.github.edsandrof.roomreservation.domain.service.impl;

import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import com.github.edsandrof.roomreservation.infrastructure.repository.LodgingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LodgingServiceImpl implements LodgingService {

    private final LodgingRepository lodgingRepository;

    @Override
    public Optional<Lodging> findById(Long id) {
        log.info("Searching for lodging id {}", id);
        Optional<Lodging> lodging = lodgingRepository.findById(id);

        log.info("Lodging with id {} was found: {}", id, lodging.isPresent());
        return lodging;
    }
}
