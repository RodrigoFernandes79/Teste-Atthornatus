package com.atthornatus.apicadastropessoa.domain.endereco;

import com.atthornatus.apicadastropessoa.domain.endereco.enums.EnderecoPrincipal;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEnderecoDTO(
        @NotBlank(message = "{endereco.obrigatorio}")
        String logradouro,
        @NotBlank(message = "{endereco.obrigatorio}")
        String cep,
        String numero,
        @NotBlank(message = "{endereco.obrigatorio}")
        String cidade,

        Pessoa pessoa,
       @NotNull(message = "{principal.obrigatorio}")
       EnderecoPrincipal enderecoPrincipal
) {
}
