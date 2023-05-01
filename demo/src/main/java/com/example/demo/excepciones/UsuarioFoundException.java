package com.example.demo.excepciones;

/*
* Este código define una clase llamada UsuarioFoundException que extiende la clase Exception. Esta excepción se lanza
* cuando se intenta guardar un usuario en la base de datos y se detecta que ya existe un usuario con el mismo
* nombre de usuario.
* La excepción tiene dos constructores, uno sin argumentos que establece un mensaje de error predeterminado, y otro
* que permite especificar un mensaje de error personalizado.
* */
public class UsuarioFoundException extends Exception{

    public UsuarioFoundException(){
        super("El usuario con ese username ya existe en la base de datos, Ingrese otro usuario");
    }

    public UsuarioFoundException(String mensaje){
        super(mensaje);
    }
}
