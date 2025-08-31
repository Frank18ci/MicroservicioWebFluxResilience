package org.carpio.com.clienteservice.controller;

import org.carpio.com.clienteservice.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(new Cliente(id, "Juan", "Perez", "juanperez@gmail.com", "555-1234"));
    }
}
