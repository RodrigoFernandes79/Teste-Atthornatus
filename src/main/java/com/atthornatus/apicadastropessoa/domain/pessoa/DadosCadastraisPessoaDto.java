package com.atthornatus.apicadastropessoa.domain.pessoa;

import java.time.LocalDate;

public record DadosCadastraisPessoaDto(
        String nome,
        LocalDate dataDeNascimento,
        String logradouro,
        String cep,
        String numero,
        String cidade
) {
}
