package com.booking.app.springboot_booking.controller;

import com.booking.app.springboot_booking.entity.GuestDetails;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.service.GuestDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/guestdetails")
@Controller
public class GuestDetailsController {

    private final GuestDetailsService guestDetailsService;

    @GetMapping
    public ResponseEntity<List<GuestDetails>> getGuestDetails(){
        return ResponseEntity.ok(guestDetailsService.getAllGuestDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDetails> getGuestDetail(@PathVariable Long id){
        return ResponseEntity.ok(guestDetailsService.getGuestDetail(id));
    }

    @PostMapping
    public ResponseEntity<GuestDetails> saveGuestDetails(@RequestBody GuestDetails guestDetails){
        return ResponseEntity.ok(guestDetailsService.saveGuestDetails(guestDetails));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestDetails> updateGuestDetails(@PathVariable Long id, @RequestBody GuestDetails guestDetails){
        return ResponseEntity.ok(guestDetailsService.updateGuestDetails(id, guestDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuestDetails(@PathVariable Long id){
        return ResponseEntity.ok(guestDetailsService.deleteGuestDetails(id));
    }
}
