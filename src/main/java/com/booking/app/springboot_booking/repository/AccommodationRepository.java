package com.booking.app.springboot_booking.repository;

import com.booking.app.springboot_booking.entity.Accommodation;
import com.booking.app.springboot_booking.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
