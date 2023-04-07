package com.atthornatus.apicadastropessoa.exceptions;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsControllerAdvice  {



		@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosCampoValidacao>> tratamentoErroValidacao400(MethodArgumentNotValidException ex) {

				var errors = ex.getFieldErrors();
        var erro = errors.stream().map(DadosCampoValidacao::new).toList();

        return ResponseEntity.badRequest().body(erro);
    }

    private record DadosCampoValidacao(String erro, String mensagem) {

        public DadosCampoValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> tratarErroNotFound404() {
        return ResponseEntity.notFound().build();
    }
}
