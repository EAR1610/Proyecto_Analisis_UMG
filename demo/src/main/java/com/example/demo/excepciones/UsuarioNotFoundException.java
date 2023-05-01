package com.example.demo.excepciones;

/*
* Esto es una clase Java que extiende de la clase Exception. La clase se llama UsuarioNotFoundException y su objetivo
* es representar una excepción cuando un usuario no es encontrado en la base de datos.
* La clase tiene dos constructores, uno sin parámetros que establece un mensaje predeterminado, y otro con un parámetro
* para que se pueda pasar un mensaje personalizado al momento de lanzar la excepción.
* El mensaje predeterminado indica que el usuario con el nombre de usuario proporcionado no existe en la base de
* datos y sugiere ingresar otro nombre de usuario.
*/
public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario con ese username no existe en la base de datos, Ingrese otro usuario");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
