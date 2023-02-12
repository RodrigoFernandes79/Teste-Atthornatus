package com.atthornatus.apicadastropessoa.controllers;

import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarPessoa(
            @RequestBody DadosCadastraisPessoaDto dadosCadastraisPessoaDto,
            UriComponentsBuilder uriComponentsBuilder) {
        Pessoa pessoa = pessoaService.criarPessoa(dadosCadastraisPessoaDto);
        var uri = uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
