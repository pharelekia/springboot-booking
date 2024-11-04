package com.booking.app.springboot_booking.controller;

import com.booking.app.springboot_booking.entity.Guest;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/guests")
@Controller
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests(){
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuest(@PathVariable Long id){
        return ResponseEntity.ok(guestService.getGuest(id));
    }

    @PostMapping
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest){
        return ResponseEntity.ok(guestService.saveGuest(guest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest){
        return ResponseEntity.ok(guestService.updateGuest(id, guest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long id){
        return ResponseEntity.ok(guestService.deleteGuest(id));
    }
}
