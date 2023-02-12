package com.atthornatus.apicadastropessoa.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroValidacao(MethodArgumentNotValidException ex) {
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
    public ResponseEntity tratarErroNotFound404() {
        return ResponseEntity.notFound().build();
    }
}
