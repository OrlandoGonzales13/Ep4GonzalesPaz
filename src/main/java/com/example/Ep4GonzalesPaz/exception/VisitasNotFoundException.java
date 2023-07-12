package com.example.Ep4GonzalesPaz.exception;

public class VisitasNotFoundException extends RuntimeException{

    public VisitasNotFoundException(Long id){
        super(String.format("REGISTRADO, INGRESAR SOLO USUARIOS NUEVOS", id));
    }
}
