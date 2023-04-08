package com.atthornatus.apicadastropessoa.controllers;

import com.atthornatus.apicadastropessoa.domain.pessoa.AtualizarDadosDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;

import com.atthornatus.apicadastropessoa.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("pessoas")
@Profile("dev")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarPessoa(
            @Valid @RequestBody DadosCadastraisPessoaDto dadosCadastraisPessoaDto,
            UriComponentsBuilder uriComponentsBuilder) {
        Pessoa pessoa = pessoaService.criarPessoa(dadosCadastraisPessoaDto);
        var uri = uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id,
                                               @Valid @RequestBody AtualizarDadosDto atualizarDadosDto) {
        var pessoaobj = pessoaService.fromDTO(atualizarDadosDto);
        var pessoa = pessoaService.editarPessoa(id, pessoaobj);

        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id) {
        var pessoa = pessoaService.consultarPessoa(id);

        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        var pessoa = pessoaService.listarPessoas();

        return ResponseEntity.ok().body(pessoa);
    }

}
