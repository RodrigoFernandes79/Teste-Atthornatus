package com.atthornatus.apicadastropessoa.controllers;

import com.atthornatus.apicadastropessoa.domain.endereco.DadosEnderecoDTO;import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> criarEnderecoParaUmaPessoa(@PathVariable Long id,
                                                           @RequestBody DadosEnderecoDTO dadosEnderecoDto,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        var endereco = enderecoService.criarEnderecoParaUmaPessoa(id, dadosEnderecoDto);
        var uri = uriComponentsBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
