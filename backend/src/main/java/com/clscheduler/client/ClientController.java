package com.clscheduler.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/client")

public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/all")
    public ResponseEntity getAllClients() {
        List<Client> drivers = clientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(drivers);
    }
}
