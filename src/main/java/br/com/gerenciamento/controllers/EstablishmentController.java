package br.com.gerenciamento.controllers;


import br.com.gerenciamento.entities.establishment.Establishment;
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
    //Controlador de endpoint dos estabelecimentos.
    //Injeção do repository dos estabelecimentos.
    @Autowired
    private EstablishmentService establishmentService;

    //End Point para a criação de um estabelecimento.
    @PostMapping
    public ResponseEntity<Establishment> createEstablishment(@RequestBody EstablishmentDTO dto) throws Exception {
            Establishment newEstablishment = establishmentService.createEstablishment(dto);
            return new ResponseEntity<>(newEstablishment, HttpStatus.CREATED);
    }

    //Endpoint para buscar todos os estabelecimentos existentes.
    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        List<Establishment> establishments = this.establishmentService.getAllEstablishment();
        return new ResponseEntity<>(establishments, HttpStatus.OK);
    }

    //Endpoint para buscar um estabelecimento específico por ID.
    @GetMapping("/{id}")
    public ResponseEntity<Establishment> getEstablishmentById(@PathVariable Long id) throws Exception {
        Establishment establishment = this.establishmentService.findEstablishmentById(id);
        return new ResponseEntity<>(establishment, HttpStatus.OK);
    }

    //Endpoint para buscar um estabelecimento específico por Document.
    @GetMapping("document/{document}")
    public ResponseEntity<Establishment> getEstablishmentByDocument(@PathVariable String document) {
        Establishment establishment = this.establishmentService.findEstablishmentByDocument(document);
        return new ResponseEntity<>(establishment, HttpStatus.OK);
    }

    //Endpoint para alterar um cadastro de um estabelecimento.
    @PutMapping
    public ResponseEntity<Establishment> updateEstablishment(@RequestBody EstablishmentDTO dto) {
        Establishment establishment = establishmentService.updateEstablishment(dto);
        return new ResponseEntity<>(establishment, HttpStatus.OK);
    }

    //Endpoint para deletar um estabelecimento específico por ID.
    @DeleteMapping("/{id}")
    public void deleteEstablishmentById(@PathVariable Long id) {
        Establishment establishment = establishmentService.deleteEstablishmentById(id);
    }

    //Endpoint para deletar um estabelecimento específico por Document.
    @DeleteMapping("/document/{document}")
    public void deleteEstablishmentByDocument(@PathVariable String document) {
        Establishment establishment = establishmentService.deleteEstablishmentByDocument(document);
    }
}
