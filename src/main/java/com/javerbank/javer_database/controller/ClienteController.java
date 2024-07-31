package com.javerbank.javer_database.controller;

import com.javerbank.javer_database.controller.dto.AtualizarClienteDto;
import com.javerbank.javer_database.controller.dto.CriarClienteDto;
import com.javerbank.javer_database.entity.Cliente;
import com.javerbank.javer_database.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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
    public Iterable<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody AtualizarClienteDto atualizarClienteDto) {
        return clienteService.atualizarCliente(id, atualizarClienteDto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
    }
