package org.Ideyalabs.CabBooking.exception;

public class UserByIdDoesNotExistException extends RuntimeException {
    public UserByIdDoesNotExistException(String string) {
        super(string);
    }
}
