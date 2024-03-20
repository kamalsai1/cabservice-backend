package org.Ideyalabs.CabBooking.exception;

public class CustomerByIdDoesNotExistException extends  Throwable{
    public CustomerByIdDoesNotExistException(String string){
        super(string);
    }
}
