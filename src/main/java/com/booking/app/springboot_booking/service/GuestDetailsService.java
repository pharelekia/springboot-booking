package com.booking.app.springboot_booking.service;

import com.booking.app.springboot_booking.entity.GuestDetails;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.exception.GuestDetailsNotFoundException;
import com.booking.app.springboot_booking.exception.HostNotFoundException;
import com.booking.app.springboot_booking.repository.GuestDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestDetailsService {

    private final GuestDetailsRepository guestDetailsRepository;

    public List<GuestDetails> getAllGuestDetails(){
        return guestDetailsRepository.findAll();
    }

    public GuestDetails getGuestDetail(Long id){
        return guestDetailsRepository.findById(id).orElseThrow(()-> new GuestDetailsNotFoundException("GuestDetails with the id "+id+" not found"));
    }

    public GuestDetails saveGuestDetails(GuestDetails guestDetails){
        return guestDetailsRepository.save(guestDetails);
    }

    public GuestDetails updateGuestDetails(Long id, GuestDetails guestDetails){
        GuestDetails guestDetails1 = getGuestDetail(id);
        guestDetails1.setMaritalStatus(guestDetails.getMaritalStatus());
        guestDetails1.setNumberOfChildren(guestDetails.getNumberOfChildren());
        return guestDetailsRepository.save(guestDetails1);
    }

    public String deleteGuestDetails(Long id){
        GuestDetails guestDetails = getGuestDetail(id);
        guestDetailsRepository.delete(guestDetails);
        return "GuestDetails deleted";
    }
}
