package com.javaexpress.accounts.exception;

public class CustomerNotFoundException extends  RuntimeException{

    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
