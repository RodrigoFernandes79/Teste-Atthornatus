package com.atthornatus.apicadastropessoa.domain.endereco;

import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Pessoa pessoa;

    private String cidade;
}
