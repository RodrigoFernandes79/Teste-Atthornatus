package com.atthornatus.apicadastropessoa.domain.endereco;

import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;

public record DadosEnderecoDTO(
        String logradouro,
        String cep,
        String numero,
        String cidade,

        Pessoa pessoa
) {
}
