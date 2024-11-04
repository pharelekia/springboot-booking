package com.booking.app.springboot_booking.service;

import com.booking.app.springboot_booking.entity.Guest;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.exception.GuestNotFoundException;
import com.booking.app.springboot_booking.exception.HostNotFoundException;
import com.booking.app.springboot_booking.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    public Guest getGuest(Long id){
        return guestRepository.findById(id).orElseThrow(()-> new GuestNotFoundException("Guest with the id "+id+" not found"));
    }

    public Guest saveGuest(Guest guest){
        return guestRepository.save(guest);
    }

    public Guest updateGuest(Long id, Guest guest){
        Guest guest1 = getGuest(id);
        guest1.setName(guest.getName());
        guest1.setAge(guest.getAge());
        return guestRepository.save(guest1);
    }

    public String deleteGuest(Long id){
        Guest guest = getGuest(id);
        guestRepository.delete(guest);
        return "Guest deleted";
    }
}
