package com.booking.app.springboot_booking.controller;

import com.booking.app.springboot_booking.entity.Accommodation;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/accommodations")
@Controller
public class AccommodationController {

    private final AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAccommodations(){
        return ResponseEntity.ok(accommodationService.getAllAccommodations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodation(@PathVariable Long id){
        return ResponseEntity.ok(accommodationService.getAccommodation(id));
    }

    @PostMapping
    public ResponseEntity<Accommodation> saveAccommodation(@RequestBody Accommodation accommodation){
        return ResponseEntity.ok(accommodationService.saveAccommodation(accommodation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodation){
        return ResponseEntity.ok(accommodationService.updateAccommodation(id, accommodation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccommodation(@PathVariable Long id){
        return ResponseEntity.ok(accommodationService.deleteAccommodation(id));
    }
}
