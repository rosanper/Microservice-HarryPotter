package com.letscode.microservicoharrypotter.exceptions;



public class NotFoundError extends RuntimeException{
    public NotFoundError(String message) {
        super(message);
    }
}
