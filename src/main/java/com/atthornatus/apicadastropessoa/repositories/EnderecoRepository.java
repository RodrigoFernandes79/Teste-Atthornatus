package com.atthornatus.apicadastropessoa.repositories;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByPessoa(Pessoa pessoa);
}
