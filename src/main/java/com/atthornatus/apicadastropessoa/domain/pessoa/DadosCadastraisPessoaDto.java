package com.atthornatus.apicadastropessoa.domain.pessoa;

import com.atthornatus.apicadastropessoa.domain.endereco.enums.EnderecoPrincipal;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DadosCadastraisPessoaDto(
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento,
        String logradouro,
        String cep,
        String numero,
        String cidade,
       EnderecoPrincipal enderecoPrincipal
) {
}
