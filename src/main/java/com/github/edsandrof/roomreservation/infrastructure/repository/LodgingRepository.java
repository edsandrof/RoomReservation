package com.github.edsandrof.roomreservation.infrastructure.repository;

import com.github.edsandrof.roomreservation.domain.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Long> {
}
