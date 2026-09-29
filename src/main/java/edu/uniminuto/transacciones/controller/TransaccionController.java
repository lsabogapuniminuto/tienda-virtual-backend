package edu.uniminuto.transacciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uniminuto.transacciones.dto.TransaccionRequest;
import edu.uniminuto.transacciones.dto.TransaccionResponse;
import edu.uniminuto.transacciones.service.TransaccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/transacciones")
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<TransaccionResponse> crear(@Valid @RequestBody TransaccionRequest request) {
        TransaccionResponse response = transaccionService.procesarTransaccion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
