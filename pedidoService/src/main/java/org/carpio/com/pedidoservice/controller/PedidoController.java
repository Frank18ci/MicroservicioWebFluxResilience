package org.carpio.com.pedidoservice.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.com.pedidoservice.model.Cliente;
import org.carpio.com.pedidoservice.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final ClienteService clienteService;

    @GetMapping("/{clienteId}")
    public ResponseEntity<?> crearPedido(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
