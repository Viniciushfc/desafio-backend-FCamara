package br.com.gerenciamento.controllers;


import br.com.gerenciamento.core.domain.Establishment.Establishment;
import br.com.gerenciamento.dtos.EstablishmentDTO;
import br.com.gerenciamento.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @PostMapping
    public ResponseEntity<Establishment> createUser(@RequestBody EstablishmentDTO dto) {
        Establishment newEstablishment = establishmentService.createEstablishment(dto);
        return new ResponseEntity<>(newEstablishment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        List<Establishment> establishments = this.establishmentService.getAllEstablishment();
        return new ResponseEntity<>(establishments, HttpStatus.OK);
    }
}
