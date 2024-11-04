package com.booking.app.springboot_booking.service;

import com.booking.app.springboot_booking.entity.Booking;
import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.exception.BookingNotFoundException;
import com.booking.app.springboot_booking.exception.HostNotFoundException;
import com.booking.app.springboot_booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBooking(Long id){
        return bookingRepository.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking with the id "+id+" not found"));
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking){
        Booking booking1 = getBooking(id);
        booking1.setStartDate(booking.getStartDate());
        booking1.setEndDate(booking.getEndDate());
        return bookingRepository.save(booking1);
    }

    public String deleteBooking(Long id){
        Booking booking = getBooking(id);
        bookingRepository.delete(booking);
        return "Booking deleted";
    }
}
