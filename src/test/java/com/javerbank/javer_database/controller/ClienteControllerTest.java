package com.javerbank.javer_database.controller;

import com.javerbank.javer_database.controller.dto.AtualizarClienteDto;
import com.javerbank.javer_database.controller.dto.CriarClienteDto;
import com.javerbank.javer_database.entity.Cliente;
import com.javerbank.javer_database.service.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    // POST
    @Nested
    class DeveCriarUmClienteComSucesso {

        @Test
        @DisplayName("Deve criar um cliente com sucesso")
        void deveCriarUmClienteComSucesso() {

            // Arrange
            CriarClienteDto criarClienteDto = new CriarClienteDto(
                    "Teste",
                    40028922L,
                    1500F
            );

            Cliente clienteEsperado = new Cliente(
                    criarClienteDto.getNome(),
                    criarClienteDto.getTelefone(),
                    criarClienteDto.getSaldoCc(),
                    Instant.now(),
                    null
            );

            when(clienteService.criarCliente(criarClienteDto)).thenReturn(clienteEsperado);

            // Act
            Cliente clienteCriado = clienteController.criar(criarClienteDto);

            // Assert
            assertEquals(clienteEsperado, clienteCriado);
            verify(clienteService, times(1)).criarCliente(criarClienteDto);
        }

        @Test
        @DisplayName("Não deve criar cliente com campos vazios")
        void naoDeveCriarUmClienteComCamposVazios() {

            // Arrange
            CriarClienteDto criarClienteDto = new CriarClienteDto();

            when(clienteService.criarCliente(criarClienteDto)).thenThrow(new IllegalArgumentException());

            // Act & Assert
            assertThrows(IllegalArgumentException.class, () -> clienteController.criar(criarClienteDto));
        }
    }

    // GET LIST
    @Nested
    class DeveRetornarUmaListaDeClientes {

        @Test
        @DisplayName("Deve retornar uma lista de clientes CASO existam clientes para serem retornados")
        void deveRetornarUmaListaDeClientes() {

            // Arrange
            List<Cliente> clientesEsperados = Arrays.asList(
                    new Cliente(
                            "Joãozinho",
                            40028922L,
                            2000F),

                    new Cliente(
                            "Pedrinho",
                            40028923L,
                            5000F)
            );

            when(clienteController.listar()).thenReturn(clientesEsperados);

            // Act
            List<Cliente> clientesRetornados = clienteController.listar();

            // Assert
            assertEquals(clientesEsperados, clientesRetornados);
            verify(clienteService, times(1)).listarClientes();
        }
    }

    // GET BY ID
    @Nested
    class DeveRetornarClientePorId {

        @Test
        @DisplayName("Deve retornar um cliente por ID")
        void deveRetornarClientePorId() {

            // Arrange
            Long clienteId = 1L;
            Cliente clienteEsperado = new Cliente(
                    1L,
                    "Pedro",
                    123456789L,
                    true,
                    2000F,
                    Instant.now(),
                    null
            );

            when(clienteController.getById(clienteId)).thenReturn(clienteEsperado);

            // Act
            Cliente response = clienteController.getById(clienteId);
        }
    }

    // PUT
    @Nested
    class DeveAtualizarUmCliente {

        @Test
        @DisplayName("Deve atualizar um cliente")
        void deveAtualizarUmCliente() {

            // Arrange
            Long clienteId = 1L;
            Long novoTelefone = 23568914L;

            AtualizarClienteDto atualizarClienteDto = new AtualizarClienteDto(novoTelefone);

            Cliente clienteEsperado = new Cliente();
            clienteEsperado.setClienteId(clienteId);
            clienteEsperado.setTelefone(novoTelefone);

            when(clienteService.atualizarCliente(clienteId, atualizarClienteDto)).thenReturn(clienteEsperado);

            // Act
            Cliente clienteAtualizado = clienteController.atualizar(clienteId, atualizarClienteDto);

            // Assert
            assertEquals(clienteEsperado, clienteAtualizado);
            assertEquals(novoTelefone, clienteEsperado.getTelefone());
        }
    }

    // DELETE
    @Nested
    class DeveDeletarUmClienteComSucesso {

        @Test
        @DisplayName("Deve deletar um cliente com sucesso")
        void deveDeletarUmClienteComSucesso() {

            // Arrange
            Long clienteId = 1L;

            // Act
            ResponseEntity<Void> response = clienteController.excluir(clienteId);

            // Assert
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }
}