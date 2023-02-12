package com.atthornatus.apicadastropessoa.repositories;

import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
