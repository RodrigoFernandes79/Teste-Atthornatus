package com.atthornatus.apicadastropessoa.services;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.repositories.EnderecoRepository;
import com.atthornatus.apicadastropessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa criarPessoa(DadosCadastraisPessoaDto dadosCadastraisPessoaDto) {

        var pessoa = fromDto(dadosCadastraisPessoaDto);
        pessoaRepository.save(pessoa);
        enderecoRepository.saveAll(pessoa.getEnderecos());

        return pessoa;

    }

    private Pessoa fromDto(DadosCadastraisPessoaDto dadosCadastraisPessoaDto) {
        Pessoa pessoa = new Pessoa(null, dadosCadastraisPessoaDto.nome(),
                dadosCadastraisPessoaDto.dataDeNascimento());
        Endereco endereco = new Endereco(null, dadosCadastraisPessoaDto.logradouro(),
                dadosCadastraisPessoaDto.cep(), dadosCadastraisPessoaDto.numero(), pessoa,
                dadosCadastraisPessoaDto.cidade());
        pessoa.getEnderecos().add(endereco);

        return pessoa;
    }
}
