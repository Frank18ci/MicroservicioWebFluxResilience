package org.carpio.com.pedidoservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.carpio.com.pedidoservice.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final WebClient webClient;

    @CircuitBreaker(name = "clienteService", fallbackMethod = "fallBackCliente")
    public Cliente obtenerClientePorId(Long id) {
        try{
            return webClient.get()
                    .uri("/clientes/{id}", id)
                    .retrieve()
                    .bodyToMono(Cliente.class)
                    .block();
        } catch (Exception e){
            return fallBackCliente(id, e);
        }
    }

    public Cliente fallBackCliente(Long id, Throwable ex){
        return new Cliente(id, "Cliente", "Default", "", "000-0000");
    }
}
