package br.org.roger.spring.exception;

/**
 * Created by selma on 21/11/2015.
 */
public class AuthenticationRequiredException extends RuntimeException {

    public AuthenticationRequiredException() {
    }

    public AuthenticationRequiredException(String message) {
        super(message);
    }
}
