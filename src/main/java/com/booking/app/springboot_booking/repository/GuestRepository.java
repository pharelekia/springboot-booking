package com.booking.app.springboot_booking.repository;

import com.booking.app.springboot_booking.entity.Guest;
import com.booking.app.springboot_booking.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
