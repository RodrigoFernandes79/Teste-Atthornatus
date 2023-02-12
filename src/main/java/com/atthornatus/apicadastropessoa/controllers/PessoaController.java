package com.atthornatus.apicadastropessoa.controllers;

import com.atthornatus.apicadastropessoa.domain.pessoa.AtualizarDadosDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.repositories.PessoaRepository;
import com.atthornatus.apicadastropessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id,
                                               @RequestBody AtualizarDadosDto atualizarDadosDto) {
        var pessoaobj = pessoaService.fromDTO(atualizarDadosDto);
        var pessoa = pessoaService.editarPessoa(id, pessoaobj);

        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        var pessoa = pessoaService.listarPessoas();

        return ResponseEntity.ok().body(pessoa);
    }

}
