package br.com.ericsoncbizarro.Integracao.cobranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestHttpPulsarPayException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadRequestHttpPulsarPayException(String exception) {
        super(exception);
    }

}

