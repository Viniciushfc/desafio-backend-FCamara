package br.com.gerenciamento.controllers;

import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import br.com.gerenciamento.services.ExitEntryControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
