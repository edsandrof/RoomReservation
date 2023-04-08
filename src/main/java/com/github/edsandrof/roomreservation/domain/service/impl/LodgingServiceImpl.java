package com.github.edsandrof.roomreservation.domain.service.impl;

import com.github.edsandrof.roomreservation.domain.Lodging;
import com.github.edsandrof.roomreservation.domain.service.LodgingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LodgingServiceImpl implements LodgingService {

    @Override
    public Optional<Lodging> findById(Long id) {
        return Optional.empty();
    }
}
