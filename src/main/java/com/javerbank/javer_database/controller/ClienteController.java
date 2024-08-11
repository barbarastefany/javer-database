package com.javerbank.javer_database.controller;

import com.javerbank.javer_database.controller.dto.AtualizarClienteDto;
import com.javerbank.javer_database.controller.dto.CriarClienteDto;
import com.javerbank.javer_database.entity.Cliente;
import com.javerbank.javer_database.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteController() {
    }

    @PostMapping
    public Cliente criar(@RequestBody CriarClienteDto criarClienteDto) {
        return clienteService.criarCliente(criarClienteDto);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{clienteId}")
    public Cliente getById(@PathVariable Long clienteId) {
        return clienteService.buscarClientePorId(clienteId);
    }

    @PutMapping("/{clienteId}")
    public Cliente atualizar(@PathVariable Long clienteId, @RequestBody AtualizarClienteDto atualizarClienteDto) {
        return clienteService.atualizarCliente(clienteId, atualizarClienteDto);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
        clienteService.deletarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteId}/limite-credito")
    public ResponseEntity<String> getLimiteCredito(@PathVariable Long clienteId) {
        Float limiteCredito = clienteService.calcularLimiteCredito(clienteId);
        if (limiteCredito != null && limiteCredito >= 0.0f) {
            String mensagem = "O limite de crédito disponível para o cliente "+clienteId+" é de: "+limiteCredito;
            return ResponseEntity.ok(mensagem);
        } else {
            String mensagemErro = "O cliente "+clienteId+" não foi encontrado na base de dados.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
        }
    }
}
