package com.atthornatus.apicadastropessoa.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.atthornatus.apicadastropessoa.domain.endereco.enums.EnderecoPrincipal;
import com.atthornatus.apicadastropessoa.domain.pessoa.DadosCadastraisPessoaDto;
import com.atthornatus.apicadastropessoa.domain.pessoa.Pessoa;
import com.atthornatus.apicadastropessoa.services.PessoaService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PessoaService pessoaService;

	@Autowired
	private JacksonTester<DadosCadastraisPessoaDto> dadosEntradaJTester;

	@Autowired
	private JacksonTester<List<Pessoa>> dadosSaidaJTester;

	@Test
	@DisplayName("Deveria retornar um codigo 201 quando informações estiverem válidas")
	void testCriarPessoa_Cenario1() throws IOException, Exception {
		// mockando a classe service com mockito
		Pessoa pessoa = new Pessoa(
				null, "Adolpho", LocalDate.of(1998, 11, 8));
		when(pessoaService.criarPessoa(any())).thenReturn(pessoa);

		var response = mockMvc.perform(post("/pessoas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosEntradaJTester.write(new DadosCadastraisPessoaDto("Adolpho",
						LocalDate.of(1998, 11, 8), "RuaTeste", "12345678", null,
						"CidadeTeste", EnderecoPrincipal.SIM)).getJson()))
				.andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

	}

	@Test
	@DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
	void testCriarPessoa_Cenario2() throws IOException, Exception {
		// mockando a classe service com mockito
		Pessoa pessoa = new Pessoa(
				null, "Adolpho", LocalDate.of(1998, 11, 8));
		when(pessoaService.criarPessoa(any())).thenReturn(pessoa);

		var response = mockMvc.perform(post("/pessoas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosEntradaJTester.write(new DadosCadastraisPessoaDto(null,
						LocalDate.of(1998, 11, 8), null, null, null,
						"CidadeTeste", EnderecoPrincipal.SIM)).getJson()))
				.andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

	}

	@Test
	@DisplayName("Deveria retornar o codigo 200 e uma lista de pessoas")
	void testListarPessoas() throws IOException, Exception {
		// Arrange
		List<Pessoa> pessoas = new ArrayList<>();

		var pessoa = new Pessoa(null, "Adolpho", LocalDate.of(1998, 11, 8));

		pessoas.add(pessoa);
		when(pessoaService.listarPessoas()).thenReturn(pessoas);

		// Act
		var response = mockMvc.perform(get("/pessoas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosEntradaJTester.write(new DadosCadastraisPessoaDto("Adolpho",
						LocalDate.of(1998, 11, 8), "RuaTeste", "12345678", null,
						"CidadeTeste", EnderecoPrincipal.SIM)).getJson()))
				.andReturn().getResponse();

		// Assert
		List<Pessoa> pessoasRetornadas = pessoaService.listarPessoas();
		var JsonEsperado = dadosSaidaJTester.write(pessoasRetornadas).getJson();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(JsonEsperado);

	}

}
