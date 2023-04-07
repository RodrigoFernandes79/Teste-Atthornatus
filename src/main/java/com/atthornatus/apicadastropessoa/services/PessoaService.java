package com.atthornatus.apicadastropessoa.services;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;

import com.atthornatus.apicadastropessoa.domain.pessoa.AtualizarDadosDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.repositories.EnderecoRepository;
import com.atthornatus.apicadastropessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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

    public Pessoa editarPessoa(Long id, Pessoa pessoa) {

        return pessoaRepository.findById(id).map(obj -> {
            obj.getId();
            obj.setNome(pessoa.getNome());
            obj.setDataDeNascimento(pessoa.getDataDeNascimento());

            return pessoaRepository.save(obj);
        }).orElseThrow(RuntimeException::new);
    }

    public Pessoa consultarPessoa(Long id) {

        return pessoaRepository.findById(id)
                .orElseThrow(RuntimeException::new);

    }

    public List<Pessoa> listarPessoas() {

        return pessoaRepository.findAll();
    }

    public  Pessoa fromDto(DadosCadastraisPessoaDto dadosCadastraisPessoaDto) {
        Pessoa pessoa = new Pessoa(null, dadosCadastraisPessoaDto.nome(),
                dadosCadastraisPessoaDto.dataDeNascimento());
        Endereco endereco = new Endereco(null, dadosCadastraisPessoaDto.logradouro(),
                dadosCadastraisPessoaDto.cep(), dadosCadastraisPessoaDto.numero(), pessoa,
                dadosCadastraisPessoaDto.cidade(), dadosCadastraisPessoaDto.enderecoPrincipal());

        pessoa.getEnderecos().add(endereco);


        return pessoa;
    }


    public Pessoa fromDTO(AtualizarDadosDto atualizarDadosDto) {

        return new Pessoa(null, atualizarDadosDto.nome(),
                atualizarDadosDto.dataDeNascimento(), null);
    }

}
