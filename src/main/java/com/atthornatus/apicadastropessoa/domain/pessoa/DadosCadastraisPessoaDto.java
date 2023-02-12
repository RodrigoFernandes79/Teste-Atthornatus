package com.atthornatus.apicadastropessoa.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DadosCadastraisPessoaDto(
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento,
        String logradouro,
        String cep,
        String numero,
        String cidade
) {
}
