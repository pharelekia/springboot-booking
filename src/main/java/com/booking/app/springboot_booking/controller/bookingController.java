package com.booking.app.springboot_booking.controller;

import com.booking.app.springboot_booking.entity.Booking;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/bookings")
@Controller
public class bookingController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getBooking(id));
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.deleteBooking(id));
    }
}
