package br.com.gerenciamento.controllers;

import br.com.gerenciamento.entities.exitEntryControl.ExitEntryControl;
import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import br.com.gerenciamento.services.ExitEntryControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/control")
public class ExitEntryControlController {
    //Controlador de endpoint dos controles de saída/entrada.
    //Injeção do repository dos controles de saída/entrada.
    @Autowired
    private ExitEntryControlService exitEntryControlService;

    //End Point para a criação de controles de saída/entrada.
    @PostMapping
    public ResponseEntity<ExitEntryControl> createExitEntryControl(@RequestBody ExitEntryControlDTO dto) {
        ExitEntryControl exitEntryControl = exitEntryControlService.createExitEntryControl(dto);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.CREATED);
    }

    //Endpoint para buscar todos os controles de saída/entrada.
    @GetMapping
    public ResponseEntity<List<ExitEntryControl>> getAllExitEntryControl(){
        List<ExitEntryControl> exitEntryControls = exitEntryControlService.getAllExitEntryControl();
        return new ResponseEntity<>(exitEntryControls, HttpStatus.OK);
    }

    //Endpoint para buscar um controles de saída/entrada.
    @GetMapping("/{id}")
    public ResponseEntity<ExitEntryControl> getExitEntryControlById(@PathVariable Long id) throws Exception {
        ExitEntryControl exitEntryControl = exitEntryControlService.getExitEntryControlById(id);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.OK);
    }

    //Endpoint para dar a saída do veículo mais valor a pagar.
    @PutMapping("/{id}")
    public ResponseEntity<ExitEntryControl> updateExitControl(@PathVariable Long id) {
        ExitEntryControl exitEntryControl = exitEntryControlService.updateExitControl(id);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.OK);
    }

    //Endpoint para alterar um cadastro de um controles de saída/entrada.
    @PutMapping("/update/{id}")
    public ResponseEntity<ExitEntryControl> updateExitEntryControl(@PathVariable Long id, @RequestBody ExitEntryControlDTO dto) {
        ExitEntryControl exitEntryControl = exitEntryControlService.updateExitEntryControl(id, dto);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.OK);
    }

    //Endpoint para deletar um controles de saída/entrada específico por ID.
    @DeleteMapping("/{id}")
    public void deleteExitEntryControl(@PathVariable Long id) {
        ExitEntryControl exitEntryControl = exitEntryControlService.deleteExitEntryControlById(id);
    }

}
