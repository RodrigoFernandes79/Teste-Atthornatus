package com.atthornatus.apicadastropessoa.controllers;

import com.atthornatus.apicadastropessoa.domain.endereco.DadosEnderecoDTO;
import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("enderecos")
@Profile("dev")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> criarEnderecoParaUmaPessoa(@PathVariable Long id,
                                                           @Valid @RequestBody DadosEnderecoDTO dadosEnderecoDto,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        var endereco = enderecoService.criarEnderecoParaUmaPessoa(id, dadosEnderecoDto);
        var uri = uriComponentsBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<List<Endereco>> listarEnderecosDeUmaPessoa(@PathVariable Long id) {
        List<Endereco> endereco = enderecoService.listarEnderecosDeUmaPessoa(id);

        return ResponseEntity.ok().body(endereco);
    }
}
