package com.atthornatus.apicadastropessoa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByPessoaId(Long idPessoa);
}
