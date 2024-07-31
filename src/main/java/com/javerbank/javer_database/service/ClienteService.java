package com.javerbank.javer_database.service;

import com.javerbank.javer_database.controller.dto.AtualizarClienteDto;
import com.javerbank.javer_database.controller.dto.CriarClienteDto;
import com.javerbank.javer_database.entity.Cliente;
import com.javerbank.javer_database.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(CriarClienteDto criarClienteDto) {

        Cliente cliente = new Cliente(
                criarClienteDto.getNome(),
                criarClienteDto.getTelefone(),
                criarClienteDto.getSaldoCc(),
                Instant.now(),
                null);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long clienteId) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        return optionalCliente.orElseThrow(()
                -> new IllegalArgumentException("O ID de cliente "+clienteId+" não foi encontrado."));
    }

    public Cliente atualizarCliente(Long clienteId, AtualizarClienteDto atualizarClienteDto) {
        Cliente cliente = buscarClientePorId(clienteId);
        cliente.setTelefone(atualizarClienteDto.getTelefone());
        return clienteRepository.save(cliente);

    }

    public void deletarCliente(Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            throw new IllegalArgumentException("O ID de cliente "+clienteId+" não foi encontrado.");
        }
        clienteRepository.deleteById(clienteId);
    }
}



