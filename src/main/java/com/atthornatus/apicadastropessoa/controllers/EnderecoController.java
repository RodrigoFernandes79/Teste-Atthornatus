package com.atthornatus.apicadastropessoa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.atthornatus.apicadastropessoa.domain.endereco.DadosEnderecoDTO;
import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.services.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("enderecos")
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
