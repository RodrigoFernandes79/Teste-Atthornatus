package com.atthornatus.apicadastropessoa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atthornatus.apicadastropessoa.domain.endereco.DadosEnderecoDTO;
import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.repositories.EnderecoRepository;
import com.atthornatus.apicadastropessoa.repositories.PessoaRepository;

@Service
public class EnderecoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco criarEnderecoParaUmaPessoa(Long id, DadosEnderecoDTO dadosEnderecoDto) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(RuntimeException::new);

		Endereco endereco = fromDto(dadosEnderecoDto);
		endereco.setPessoa(pessoa);
		enderecoRepository.save(endereco);

		return endereco;
	}

	public List<Endereco> listarEnderecosDeUmaPessoa(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(RuntimeException::new);

		return enderecoRepository.findByPessoaId(pessoa.getId());
	}

	private Endereco fromDto(DadosEnderecoDTO dadosEnderecoDto) {
		Pessoa pessoa = new Pessoa();

		return new Endereco(null, dadosEnderecoDto.logradouro(), dadosEnderecoDto.cep(),
				dadosEnderecoDto.numero(), pessoa, dadosEnderecoDto.cidade(), dadosEnderecoDto.enderecoPrincipal());

	}

}
