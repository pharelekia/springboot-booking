package com.booking.app.springboot_booking.service;

import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.exception.HostNotFoundException;
import com.booking.app.springboot_booking.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HostService {

    private final HostRepository hostRepository;

    public List<Host> getAllHosts(){
        return hostRepository.findAll();
    }

    public Host getHost(Long id){
        return hostRepository.findById(id).orElseThrow(()-> new HostNotFoundException("Host with the id "+id+" not found"));
    }

    public Host saveHost(Host host){
        return hostRepository.save(host);
    }

    public Host updateHost(Long id, Host host){
        Host host1 = getHost(id);
        host1.setName(host.getName());
        return hostRepository.save(host1);
    }

    public String deleteHost(Long id){
        Host host = getHost(id);
        hostRepository.delete(host);
        return "Host deleted";
    }
}
