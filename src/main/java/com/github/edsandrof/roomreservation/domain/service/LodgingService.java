package com.github.edsandrof.roomreservation.domain.service;

import com.github.edsandrof.roomreservation.domain.Lodging;

import java.util.Optional;

public interface LodgingService {

    Optional<Lodging> findById(Long id);
}
