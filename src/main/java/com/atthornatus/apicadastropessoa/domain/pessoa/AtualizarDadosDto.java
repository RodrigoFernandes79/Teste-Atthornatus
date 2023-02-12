package com.atthornatus.apicadastropessoa.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarDadosDto(

        Long id,
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotNull(message = "{nascimento.obrigatorio}")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento
) {
}
