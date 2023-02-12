package com.atthornatus.apicadastropessoa.domain.pessoa;

import com.atthornatus.apicadastropessoa.domain.endereco.enums.EnderecoPrincipal;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastraisPessoaDto(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotNull(message = "{nascimento.obrigatorio}")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento,
        @NotBlank(message = "{endereco.obrigatorio}")
        String logradouro,
        @NotBlank(message = "{endereco.obrigatorio}")
        String cep,
        String numero,
        @NotBlank(message = "{endereco.obrigatorio}")
        String cidade,
        @NotNull(message = "{principal.obrigatorio}")
        EnderecoPrincipal enderecoPrincipal
) {
}
