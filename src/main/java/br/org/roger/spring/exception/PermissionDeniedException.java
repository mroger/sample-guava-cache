package br.org.roger.spring.exception;

/**
 * Created by selma on 21/11/2015.
 */
public class PermissionDeniedException extends RuntimeException {

    public PermissionDeniedException() {
    }

    public PermissionDeniedException(String message) {
        super(message);
    }

}
