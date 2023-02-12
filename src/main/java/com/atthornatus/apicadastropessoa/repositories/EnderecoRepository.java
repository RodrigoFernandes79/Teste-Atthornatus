package com.atthornatus.apicadastropessoa.repositories;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

}
