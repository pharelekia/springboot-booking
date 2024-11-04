package com.booking.app.springboot_booking.controller;

import com.booking.app.springboot_booking.entity.Host;
import com.booking.app.springboot_booking.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hosts")
@Controller
public class HostController {

    private final HostService hostService;

    @GetMapping
    public ResponseEntity<List<Host>> getHosts(){
        return ResponseEntity.ok(hostService.getAllHosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getHost(@PathVariable Long id){
        return ResponseEntity.ok(hostService.getHost(id));
    }

    @PostMapping
    public ResponseEntity<Host> saveHost(@RequestBody Host host){
        return ResponseEntity.ok(hostService.saveHost(host));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Host> updateHost(@PathVariable Long id, @RequestBody Host host){
        return ResponseEntity.ok(hostService.updateHost(id, host));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHost(@PathVariable Long id){
        return ResponseEntity.ok(hostService.deleteHost(id));
    }
}
