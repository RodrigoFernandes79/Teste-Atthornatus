package com.atthornatus.apicadastropessoa.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record AtualizarDadosDto(
        Long id,
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento
) {
}
