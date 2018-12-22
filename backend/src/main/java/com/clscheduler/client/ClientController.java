package com.clscheduler.client;


import com.clscheduler.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/client")

public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/create")
    public ResponseEntity createClient(@RequestBody Client newClient) {
        clientRepository.save(newClient);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200, "Client successfully created"));
    }

    @GetMapping("/all")
    public ResponseEntity getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }
}
