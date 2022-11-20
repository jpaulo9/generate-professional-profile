package com.desafio.dio.Gerador.Curriculo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionCustom extends Exception{

    public static void check(boolean expression, HttpStatus status, String msg) {

        if (expression) {
            throw new ResponseStatusException(status, msg) {

            };
        }
    }
}
