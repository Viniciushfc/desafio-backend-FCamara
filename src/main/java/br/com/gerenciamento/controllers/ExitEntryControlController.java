package br.com.gerenciamento.controllers;

import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
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

    @Autowired
    private ExitEntryControlService exitEntryControlService;

    @PostMapping
    public ResponseEntity<ExitEntryControl> createExitEntryControl(@RequestBody ExitEntryControlDTO dto){
        ExitEntryControl exitEntryControl = exitEntryControlService.createExitEntryControl(dto);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExitEntryControl>> getAllExitEntryControl(){
        List<ExitEntryControl> exitEntryControls = exitEntryControlService.getAllExitEntryControl();
        return new ResponseEntity<>(exitEntryControls, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExitEntryControl> updateExitEntryControl(@RequestBody ExitEntryControlDTO dto){
        ExitEntryControl exitEntryControl = exitEntryControlService.updateExitEntryControl(dto);
        return new ResponseEntity<>(exitEntryControl, HttpStatus.OK);
    }
}
