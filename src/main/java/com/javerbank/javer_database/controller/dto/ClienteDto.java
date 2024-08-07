package com.javerbank.javer_database.controller.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nome;
    private Long telefone;
    private Float saldoCc;

    public ClienteDto(String nome, Long telefone, Float saldoCc) {
    }
}
