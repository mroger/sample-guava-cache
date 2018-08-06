package br.org.roger.spring.exception;

/**
 * Created by chen on 04/02/2015.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
