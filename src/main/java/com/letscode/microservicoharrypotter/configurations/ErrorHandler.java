package com.letscode.microservicoharrypotter.configurations;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.letscode.microservicoharrypotter.exceptions.ErrorMessage;
import com.letscode.microservicoharrypotter.exceptions.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.time.Instant;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundError.class)
    public ErrorMessage handlerNotFoudError(NotFoundError e){
        return ErrorMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Objeto não encontrado.")
                .message(e.getMessage()).build();
    }

    @ExceptionHandler(RestClientException.class)
    public ErrorMessage handlerNotFoudError(RestClientException e){
        return ErrorMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Erro com a requisição ao cliente.")
                .message(e.getMessage()).build();
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ErrorMessage handlerEnumError(InvalidFormatException e){
        return ErrorMessage.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Erro com a informação passada.")
                .message(e.getMessage()).build();
    }


}
