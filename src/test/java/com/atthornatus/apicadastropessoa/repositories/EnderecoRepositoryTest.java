package com.atthornatus.apicadastropessoa.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.atthornatus.apicadastropessoa.domain.endereco.Endereco;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;

@AutoConfigureMockMvc
@DataJpaTest
public class EnderecoRepositoryTest {


    @MockBean
    private EnderecoRepository enderecoRepositoryMock;

    @Test
		@DisplayName("Deve retornar todas os enderecos ordenadas pelo id da pessoa")
    public void testFindByPessoaId() {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(1L);
			pessoa.setNome("Adhoplpho");
			pessoa.setDataDeNascimento(LocalDate.parse("1998-12-08"));

        // Cria um mock de Endereco
        Endereco endereco1 = new Endereco();
        endereco1.setId(1L);
        endereco1.setLogradouro("Rua A");
        endereco1.setCidade("São Paulo");
        endereco1.setPessoa(pessoa);

        Endereco endereco2 = new Endereco();
        endereco2.setId(2L);
        endereco2.setLogradouro("Rua B");
        endereco2.setCidade("Rio de Janeiro");
        endereco2.setPessoa(pessoa);

        // Cria uma lista com os endereços mockados
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);

        // Configura o comportamento do método findByPessoaId para retornar os endereços mockados
        when(enderecoRepositoryMock.findByPessoaId(1L)).thenReturn(enderecos);

        // Chama o método que será testado
        List<Endereco> result = enderecoRepositoryMock.findByPessoaId(1L);

        // Verifica se o resultado é o esperado
        assertEquals(enderecos, result);
    }
}


