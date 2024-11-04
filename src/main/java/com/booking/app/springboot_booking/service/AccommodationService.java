package com.booking.app.springboot_booking.service;

import com.booking.app.springboot_booking.entity.Accommodation;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.exception.AccommodationNotFoundException;
import com.booking.app.springboot_booking.exception.HostNotFoundException;
import com.booking.app.springboot_booking.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.findAll();
    }

    public Accommodation getAccommodation(Long id){
        return accommodationRepository.findById(id).orElseThrow(()-> new AccommodationNotFoundException("Accommodation with the id "+id+" not found"));
    }

    public Accommodation saveAccommodation(Accommodation accommodation){
        return accommodationRepository.save(accommodation);
    }

    public Accommodation updateAccommodation(Long id, Accommodation accommodation){
        Accommodation accommodation1 = getAccommodation(id);
        accommodation1.setPrice(accommodation.getPrice());
        accommodation1.setStatut(accommodation.getStatut());
        return accommodationRepository.save(accommodation1);
    }

    public String deleteAccommodation(Long id){
        Accommodation accommodation = getAccommodation(id);
        accommodationRepository.delete(accommodation);
        return "Accommodation deleted";
    }
}
